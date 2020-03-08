package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.*;
import cc.ccocc.dao.IOauthDao;
import cc.ccocc.dao.IUserDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.User;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.message.RandomMessageUtils;
import cc.ccocc.utils.passwordEncoder.MD5Utils;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 21:02  10/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("adminUserService")
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Qualifier("adminSystemNotice")
    private IAdminSystemNotificationService adminSystemNotificationService;

    @Autowired
    private IAdminArticleService adminArticleService;

    @Autowired
    private IAdminTagService adminTagService;

    @Autowired
    private IAdminArticle_CommentNotificationService adminArticle_commentNotificationService;

    @Autowired
    private IAdminArticle_LikeNotificationService adminArticle_likeNotificationService;

    @Autowired
    private IAdminArticle_UserService adminArticle_userService;

    @Autowired
    private IAdminUser_ArchivesService adminUser_archivesService;

    @Autowired
    private IAdminUser_CommentService adminUser_commentService;

    @Autowired
    private IAdminComment_ReplyService adminComment_replyService;

    @Autowired
    private IAdminSystemNotificationService systemNotificationService;

    @Autowired
    @Qualifier("adminCommentService")
    private IAdminCommentService adminCommentService;

    @Autowired
    private IOauthDao oauthDao;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @Method Description:
     * <p>查找所有用户</p>
     * @Author weleness
     * @Return
     */
    @Override
    public AdminDTO<List<User>> findAllUser(Integer pageNo, Integer pageSize) {
        return new AdminDTO<List<User>>(ResultCode.OK_CODE.getCode(), null, userDao.findAll(pageNo, pageSize), userCount(), true);
    }

    /**
     * @param email  邮箱
     * @param gender 性别
     * @param userId 用户的id
     * @param phone  手机
     * @Method Description:
     * <p>更改用户的信息</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO<User> updateUser(Long userId, String email, String phone, Boolean gender) {
        if (userDao.updateUser(userId, email, phone, gender) > 0) {
            return new AdminDTO<User>(ResultCode.OK_CODE.getCode(), null, userDao.findUserById(userId), userCount(), true);
        }
        return null;
    }

    /**
     * @param gender   性别
     * @param email    邮箱
     * @param password 密码
     * @param userName 用户名
     * @param age      年龄
     * @Method Description:
     * <p>添加新用户</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO<List<User>> addUser(String userName, String password, Short age, Boolean gender, String email) {
        if (userDao.findUserByName(userName) == null) {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            User user = User.builder().userId(ID_GENERATOR.generateId()).
                    userName(userName).password(MD5Utils.generate(password))
                    .age(age).gender(gender).email(email).
                            lastLogin(now).lastUpdate(now).
                            createTime(now).build();
            if (userDao.addDefaultUser(user) > 0) {
                return findAllUser(0, 5);
            }
        }
        return new AdminDTO<List<User>>(ResultCode.CLIENT_ERROR_CODE.getCode(), "该用户已注册", userDao.findAll(0, 5), userDao.userCount(), false);
    }



    @Override
    public Integer userCount() {
        return userDao.userCount();
    }

    /**
     * @param userIds 用户id
     * @Method Description:
     * <p>删除用户</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO<User> deleteUsers(Long[] userIds) {
        for (Long userId : userIds) {
            User user = userDao.findUserById(userId);
            if(user.getOauthId()!=null) oauthDao.deleteOauth(user.getOauthId());
            userDao.deleteUser(userId);
            adminArticleService.deleteByUser(userId);
            adminCommentService.deleteByUser(userId);
            adminTagService.deleteByUser(userId);
            adminArticle_commentNotificationService.deleteByUser(userId);
            adminArticle_likeNotificationService.deleteByUser(userId);
            adminArticle_userService.deleteByUser(userId);
            adminUser_archivesService.deleteByUser(userId);
            adminUser_commentService.deleteByUser(userId);
            systemNotificationService.deleteByUser(userId);
            adminComment_replyService.deleteByUser(userId);
        }
        return new AdminDTO<>(ResultCode.OK_CODE.getCode(), null, null, null, true);
    }

    @Override
    public AdminDTO<List<User>> searchUser(Long userId, String userName, String email) {
        AdminDTO<List<User>> result = null;
        List<User> users = userDao.searchUser(userId, userName, email);
        if (!users.contains(null)) {
            result = new AdminDTO<List<User>>(ResultCode.OK_CODE.getCode(), null, users, userCount(), true);
        } else result = new AdminDTO<List<User>>(ResultCode.NOT_FOUND_CODE.getCode(), null, null, 0, false);
        return result;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO lockedUser(Long userId, String type) {
        if (type.equals("锁定")) {
            adminSystemNotificationService.addSysteNoticeBad(userId, "账户", RandomMessageUtils.getMessage(), "您的账户已被管理员锁定");
        } else {
            adminSystemNotificationService.addSysteNoticeBad(userId, "账户", "good", "您的账号已经被管理员解除锁定，可以继续使用");
        }
        return userDao.lockedUser(userId) > 0 ? new AdminDTO<List<User>>(ResultCode.OK_CODE.getCode(), "锁定", null, null, true) : new AdminDTO<List<User>>(ResultCode.CLIENT_ERROR_CODE.getCode(), "锁定失败", null, null, false);
    }

    @Override
    public User findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    @Override
    public User findUserByArticleId(Long articleId) {
        return userDao.findUserByArticleId(articleId);
    }

}
