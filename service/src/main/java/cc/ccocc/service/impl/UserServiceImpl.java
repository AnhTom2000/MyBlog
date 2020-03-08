package cc.ccocc.service.impl;

import cc.ccocc.dao.IUserDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;
import cc.ccocc.service.*;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.passwordEncoder.MD5Utils;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Clock;
import java.time.LocalDateTime;

import static cc.ccocc.service.impl.AbstractOauthService.*;

/**
 * Created on 21:59  21/01/2020
 * Description:
 * 用户的业务层接口实现类
 *
 * @author Weleness
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Qualifier("userDao")
    @Autowired
    private IUserDao userDao;

    //private static final IdGenerator OAUTH_IDGENERATOR = SnowflakeIdGenerator.getInstance();

    @Autowired
    @Qualifier("verifyCodeEmailService")
    private IVerifyCodeEmailService verifyCodeEmailService;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Autowired
    @Qualifier("githubOauthService")
    private IOauthService githubOauthService;

    @Autowired
    @Qualifier("qqOauthService")
    private IOauthService qQOauthService;

    @Autowired
    @Qualifier("commentService")
    @Lazy
    private ICommentService commentService;

    @Autowired
    @Qualifier("archiveService")
    private IArchiveService archiveService;

    @Autowired
    @Qualifier("tagService")
    private ITagService tagService;

    @Autowired
    @Qualifier("articleService")
    private IArticleService articleService;

    /**
     * @param oauth 第三方登陆信息  因为每个平台的openId都是唯一的，而又因为有不同的平台，所以这里要分开
     * @Method Description:
     * 根据第三方登陆类型查找用户
     * @Author weleness
     * @Return
     */
    @SuppressWarnings("有需要改进的地方")
    @Override
    public UserDTO findUserByOauth(Oauth oauth) {
        UserDTO userInfo = null;
        // 创建cglib提供的beanCopier   第一个参数是被转换对象  第二个是转换对象  第三个是是否使用转换器
        BeanCopier beanCopier = BeanCopier.create(User.class, UserDTO.class, false);
        switch (oauth.getOauthType()) {
            case GITHUB_TYPE:
                // 查找用户是否使用第三方账号登陆过
                User user = userDao.findUserByGitHubOpenId(oauth.getGithubOpenId());
                //转换对象
                if (user != null) {
                    userInfo = new UserDTO();
                    beanCopier.copy(user, userInfo, null);
                    userDao.updateUserLastLogin(user.getUserId(), LocalDateTime.now(Clock.systemDefaultZone()));
                    userDao.updateUserLoginCount(user.getUserId());
                }
                break;
            case QQ_TYPE:
                break;
        }
        return userInfo;
    }


    /**
     * @param username 用户名
     * @Method Description:
     * 检查用户是否重复注册用户名
     * @Author weleness
     * @Return
     */
    @Override
    public ResultDTO checkUserExsitByName(String username) {
        User user = userDao.findUserByName(username);
        ResultDTO result = null;
        if (user == null) {
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).status(true).build();
        } else {
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("用户名已经注册").status(false).build();
        }
        return result;
    }

    /**
     * @param email 用户注册的邮箱
     * @Method Description:
     * 检查用户是否重复注册邮箱
     * @Author weleness
     * @Return
     */
    @Override
    public ResultDTO checkUserExsitByEmail(String email) {
        ResultDTO result = null;
        if (email == null) {
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("邮箱不能为空").status(false).build();
        } else {
            if (userDao.findUserByEmail(email) != null) {
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("邮箱已经被注册，请输入新的邮箱").status(false).build();
            } else {
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).status(true).build();
            }
        }
        return result;
    }


    /**
     * @param verificationCode 验证码
     * @param email            用户注册的邮箱
     * @Method Description:
     * 用户完善信息
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO oauthInformationComplete(String username, String email, String verificationCode, HttpServletRequest request, HttpServletResponse response) {
        ResultDTO result = null;
        Cookie oauthCookie = null;
        if ((result = verifyCodeEmailService.checkEmailVerifyCode(email, verificationCode)).isStatus()) {
            if ((oauthCookie = cookieService.getCookie(OAUTH_COOKIE_KEY, request)) != null) {
                // 拿出之前存放在session的oauth出来完善信息
                Oauth oauth = (Oauth) request.getSession().getAttribute(oauthCookie.getValue());
                if (oauth != null) {
                    result = addOauthUser(email, username.trim(), oauth);
                    if (result.isStatus()) {
                        cookieService.removeCookie(oauthCookie, response);
                        // 产生一个新的cookie
                        Cookie cookie = cookieService.generateCookie(SIMPLE_COOKIE_KEY);
                        request.getSession().setAttribute(cookie.getValue(), oauth.getUser().getUserId());
                       request.getSession().setMaxInactiveInterval(127800000);
                        response.addCookie(cookie);
                    } else {
                        result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("注册失败，请重试").status(false).build();
                    }
                }
            } else {
                result = ResultDTO.builder().code(ResultCode.NOT_FOUND_CODE.getCode()).message("未找到oauth").status(false).build();
            }
        }
        return result;
    }

    /**
     * @Method Description:
     * 当第三方登陆用户完善信息之后，添加第三方用户到oauth表与user表
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO addOauthUser(String email, String username, Oauth oauth) {
        ResultDTO result = null;
        try {
            oauth.getUser().setUserId(ID_GENERATOR.generateId());
            oauth.getUser().setEmail(email);
            oauth.getUser().setUserName(username);
            oauth.getUser().setPassword(MD5Utils.generate(DEFAULT_PASSWORD));
            oauth.setOauthId(ID_GENERATOR.generateId());
            switch (oauth.getOauthType()) {
                case GITHUB_TYPE:
                    githubOauthService.addOauth(oauth);
                    break;
                case QQ_TYPE:
                    qQOauthService.addOauth(oauth);
            }
            result = userDao.addOauthUser(oauth.getUser(), oauth.getOauthId()) > 0 ? ResultDTO.builder().message("操作成功").status(true).build() : ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("操作失败").status(false).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * @param name     登陆的用户名
     * @param password 要登陆用的输入的密码
     * @Method Description:
     * 登陆服务
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userDao.findUserByName(name.trim());
        ResultDTO result = null;
        if (user != null) {
            if (!user.getLocked()) {
                //如果密码正确
                if (MD5Utils.verify(password, user.getPassword())) {
                    // 用户登陆次数+1
                    userDao.updateUserLoginCount(user.getUserId());
                    // 修改用户最后一次登陆的时间
                    userDao.updateUserLastLogin(user.getUserId(), LocalDateTime.now(Clock.systemDefaultZone()));
                    // 为用户生成一个cookie
                    Cookie cookie = cookieService.generateCookie(SIMPLE_COOKIE_KEY);
                    //添加进session ， key 是 cookie的值，value 是 用户丶id
                    HttpSession session = request.getSession();
                    session.setAttribute(cookie.getValue(), user.getUserId());
                    session.setMaxInactiveInterval(172800000);
                    // 存进响应
                    response.addCookie(cookie);
                    result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("密码正确").status(true).build();
                } else {
                    result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("密码错误").status(false).build();
                }
            } else {
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("账号已被锁定，不可以登陆").status(false).build();
            }
        } else
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("用户不存在").status(false).build();
        return result;
    }

    /**
     * @param email            用户注册的邮箱
     * @param password         用户密码
     * @param verificationCode 验证码
     * @param name             用户名
     * @Method Description:
     * 用户注册服务
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO register(String name, String email, String password, String verificationCode, HttpServletRequest request, HttpServletResponse response) {
        ResultDTO result = verifyCodeEmailService.checkEmailVerifyCode(email, verificationCode);
        if (result.isStatus()) {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            Long userId = ID_GENERATOR.generateId();
            //对明文密码进行加密处理
            User user = User.builder().userName(name.trim()).email(email).password(MD5Utils.generate(password)).
                    lastUpdate(now).lastUpdate(now).lastLogin(now).createTime(now).gender(true)
                    .userId(userId).locked(false).build();
            userDao.addDefaultUser(user);

            cookieService.removeCookie(cookieService.getCookie(SIMPLE_COOKIE_KEY, request), response);

            // 为用户生成一个cookie
            Cookie cookie = cookieService.generateCookie(SIMPLE_COOKIE_KEY);
            //添加进session ， key 是 cookie的值，value 是 用户丶id
            HttpSession session = request.getSession();
            session.setAttribute(cookie.getValue(), user.getUserId());
            session.setMaxInactiveInterval(172800000);
            // 存进响应
            response.addCookie(cookie);
        }
        return result;
    }

    /**
     * @param userID 用户id
     * @Method Description:
     * 根据用户id查找用户
     * @Author weleness
     * @Return
     */
    @Override
    public UserDTO findUserById(Long userID) {
        UserDTO userDTO = new UserDTO();
        User user = null;
        if ((user = userDao.findUserById(userID)) != null) {
            // 创建cglib提供的beanCopier   第一个参数是被转换对象  第二个是转换对象  第三个是是否使用转换器
            BeanCopier beanCopier = BeanCopier.create(User.class, UserDTO.class, false);
            beanCopier.copy(user, userDTO, null);
            return userDTO;
        }
        return null;
    }

    /**
     * @Method Description:
     * 根据用户名查找用户
     * @Author weleness
     * @Return
     */
    @Override
    public User findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    /**
     * @Method Description:
     * 添加用户的所有信息
     * @Author weleness
     * @Return
     */
    @Override
    public void findUserInfo(Model model, User user) {
        model.addAttribute("author", user);
        model.addAttribute("newComments", commentService.getNewsComment(user.getUserId()));
        model.addAttribute("archive_List", archiveService.findArchives(user.getUserId()));
        model.addAttribute("article_new_List", articleService.findArticleNewByUserId(user.getUserId()));
        //model.addAttribute("user_tag", tagService.findTagByUserId(user.getUserId()));
    }

    /**
     * @param userId      用户主键
     * @param email       用户邮箱
     *                    --------------------以下为选填项
     * @param age         用户名年龄
     * @param gender      用户性别
     * @param area        用户地区
     * @param phone       用户手机号
     * @param description 用户个人简介
     * @param profession  工作
     * @Method Description:
     * 保存用户修改的操作
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO savePersonalUpdate(Long userId, String email, Short age, Boolean gender, String area, String phone, String description, String profession) {
        ResultDTO result = null;
        LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
        if (userDao.personalUpdate(User.builder().userId(userId).gender(gender).area(area).description(description).profession(profession).phone(phone).email(email).age(age).lastUpdate(now).build()) > 0) {
            result = new ResultDTO(ResultCode.OK_CODE.getCode(), "修改成功", true);
        } else result = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "修改失败", true);

        return result;
    }

    /**
     * @Method Description:
     * 用户修改头像操作
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer updateUserImage(String avatarUrl, Long userId) {
        return userDao.personalAvatarUrlUpdate(avatarUrl, LocalDateTime.now(Clock.systemDefaultZone()), userId);
    }

    /**
     * @param userId         用户主键
     * @param email          邮箱
     * @param verifyCode     验证码
     * @param modifyPassword 修改的密码
     * @Method Description:
     * 修改用户密码
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO updateUserPassword(Long userId, String email, String verifyCode, String modifyPassword, HttpServletRequest request, HttpServletResponse response) {
        ResultDTO result = null;
        if ((result = verifyCodeEmailService.checkEmailVerifyCode(email, verifyCode)).isStatus() && userDao.personalPasswordUpdate(userId, MD5Utils.generate(modifyPassword)) > 0) {
            System.out.println("e");
            cookieService.removeCookie(cookieService.getCookie(SIMPLE_COOKIE_KEY, request), response);
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("操作成功").status(true).build();
        }
        return result;
    }

    /**
     * @param userId 用户主键
     * @Method Description:
     * 用户发布文章，文章数+1
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addUserArticleCount(Long userId) {
        return userDao.addUserArticleCount(userId);
    }

    /**
     * @param userId 用户主键
     * @Method Description:
     * 用户删除文章，文章数减一
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer devUserArticleCount(Long userId) {
        return userDao.devUserArticleCount(userId);
    }

    @Override
    public User findUserByArticleId(Long articleId) {
        return userDao.findUserByArticleId(articleId);
    }

    @Override
    public User findUserByCommentId(Long commentId) {
        return userDao.findUserByCommentId(commentId);
    }


}
