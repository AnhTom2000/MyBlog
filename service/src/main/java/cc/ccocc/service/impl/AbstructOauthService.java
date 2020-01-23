package cc.ccocc.service.impl;

import cc.ccocc.dao.IOauthDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.service.IOauthService;
import cc.ccocc.service.IUserService;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 11:19  21/01/2020
 * Description:
 *
 * @author Weleness
 */

public abstract class AbstructOauthService implements IOauthService {

    // 第三方登陆用户标识
    public static final String OAUTH_COOKIE_KEY = "oauth-user";
    // 本地登录用户标识
    public static final String SIMPLE_COOKIE_KEY = "user";
    // 第三方平台github标识
    public static final String GITHUB_TYPE = "github";
    // 第三方平台 qq 标识
    public static final String QQ_TYPE = "qq";
    // 第三方平台登陆的默认密码
    public static final  String DEFAULT_PASSWORD = "8761797!";

    @Autowired
    protected IOauthDao oauthDao;

    @Autowired
    protected IUserService userService;

    //protected static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Override
    public String getRequestAuthorizeUrl() {
        return null;
    }

    @Override
    public ResultDTO callback(String state, String code, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


    @Override
    public Oauth getOauthUserInfo(String state, String code) {
        return null;
    }

    @Override
    public UserDTO getUserByOauth(Oauth oauth) {
        return null;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public boolean addOauth(Oauth oauth) {
        return oauthDao.addOauth(oauth) > 0;
    }
}
