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

    public static final String GITHUB_TYPE = "github";

    public static final String QQ_TYPE = "qq";

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

    @Override
    public boolean addOauth(Oauth oauth) {
        return oauthDao.addOauth(oauth) > 0;
    }
}
