package cc.ccocc.service.impl;

import cc.ccocc.dao.IUserDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;
import cc.ccocc.service.IUserService;
import cc.ccocc.service.IVerifyCodeEmailService;
import cc.ccocc.utils.checkCode.CheckCodeGenerator;
import cc.ccocc.utils.checkCode.CodeGenerator;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

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

    @Autowired
    @Qualifier("verifyCodeEmailService")
    private IVerifyCodeEmailService verifyCodeEmailService;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();

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
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("用户名以及注册").status(false).build();
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
        return null;
    }

    /**
     * @param verificationCode 验证码
     * @param email            用户注册的邮箱
     * @Method Description:
     * 用户完善信息
     * @Author weleness
     * @Return
     */
    @Override
    public ResultDTO oauthInformationComplete(String email, String verificationCode) {
        return null;
    }

    @Override
    public ResultDTO login(String name, String password) {
        return null;
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
    public ResultDTO register(String name, String email, String password, String verificationCode) {
        ResultDTO result = verifyCodeEmailService.checkEmailVerifyCode(email, verificationCode);
        if (result.isStatus()) {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            long userId = ID_GENERATOR.generateId();
            User user = User.builder().userName(name).email(email).password(password).salt("").
                    lastUpdate(now).lastUpdate(now).createTime(now).gender(true)
                    .userId(userId).locked(false).build();
            userDao.addDefaultUser(user);
        }
        return result;
    }


}
