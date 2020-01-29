package cc.ccocc.service.impl;

import cc.ccocc.dao.IUserDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;
import cc.ccocc.service.ICookieService;
import cc.ccocc.service.IOauthService;
import cc.ccocc.service.IUserService;
import cc.ccocc.service.IVerifyCodeEmailService;
import cc.ccocc.utils.checkCode.CheckCodeGenerator;
import cc.ccocc.utils.checkCode.CodeGenerator;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.passwordEncoder.MD5Utils;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.LocalDateTime;

import static cc.ccocc.service.impl.AbstructOauthService.*;

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

        UserDTO userInfo = new UserDTO();
        // 创建cglib提供的beanCopier   第一个参数是被转换对象  第二个是转换对象  第三个是是否使用转换器
        BeanCopier beanCopier = BeanCopier.create(User.class, UserDTO.class, false);
        switch (oauth.getOauthType()) {
            case GITHUB_TYPE:
                User user = userDao.findUserByGitHubOpenId(oauth.getGithubOpenId());
                //转换对象
                if (user != null) {
                    beanCopier.copy(user, userInfo, null);
                }
                break;
            case QQ_TYPE:
                break;
        }
        return userInfo;
    }

    @Override
    public ResultDTO doInformationComplete() {
        return null;
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
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("邮箱不能为空").status(false).build();
        } else {
            if (userDao.findUserByEamil(email) != null) {
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("邮箱已经被注册，请输入新的邮箱").status(false).build();
            } else {
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).status(true).build();
            }
        }
        return result;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    /**
     * @param verificationCode 验证码
     * @param email            用户注册的邮箱
     * @Method Description:
     * 用户完善信息
     * @Author weleness
     * @Return
     */
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
     * @Method
     * Description:
     *  当第三方登陆用户完善信息之后，添加第三方用户到oauth表与user表
     * @Author weleness
     *
     * @Return
     */
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
     * @param name 登陆的用户名
     * @param password  要登陆用的输入的密码
     * @Method
     * Description:
     *  登陆服务
     * @Author weleness
     *
     * @Return
     */
    @Override
    public ResultDTO login(String name, String password,HttpServletRequest request,HttpServletResponse response) {
        User user = userDao.findUserByName(name.trim());
        ResultDTO result = null;
        if (user != null) {
            //如果密码正确
            if(MD5Utils.verify(password, user.getPassword())){
                // 为用户生成一个cookie
                Cookie cookie = cookieService.generateCookie(SIMPLE_COOKIE_KEY);
                //添加进session ， key 是 cookie的值，value 是 用户丶id
                request.getSession().setAttribute(cookie.getValue(),user.getUserId());
                // 存进响应
                response.addCookie(cookie);
                result =ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("密码正确").status(true).build();
            }else {
                result =  ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("密码错误").status(false).build();
            }

        }else  result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("用户不存在").status(false).build();
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

    @Override
    public ResultDTO register(String name, String email, String password, String verificationCode ,HttpServletRequest request,HttpServletResponse response) {
        ResultDTO result = verifyCodeEmailService.checkEmailVerifyCode(email, verificationCode);
        if (result.isStatus()) {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            Long userId = ID_GENERATOR.generateId();
            //对明文密码进行加密处理
            User user = User.builder().userName(name.trim()).email(email).password(MD5Utils.generate(password)).
                    lastUpdate(now).lastUpdate(now).lastLogin(now).createTime(now).gender(true)
                    .userId(userId).locked(false).build();
            userDao.addDefaultUser(user);
            // 为用户生成一个cookie
            Cookie cookie = cookieService.generateCookie(SIMPLE_COOKIE_KEY);
            //添加进session ， key 是 cookie的值，value 是 用户丶id
            request.getSession().setAttribute(cookie.getValue(),user.getUserId());
            // 存进响应
            response.addCookie(cookie);
        }
        return result;
    }

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




}
