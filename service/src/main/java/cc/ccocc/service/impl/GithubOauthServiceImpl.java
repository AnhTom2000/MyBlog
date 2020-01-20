package cc.ccocc.service.impl;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IOauthService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 23:49  20/01/2020
 * Description:
 *
 * @author Weleness
 */

@Service("githubOauthService")
public class GithubOauthServiceImpl implements IOauthService {


    //github客户端ID
    private final String CLIENT_ID = "39acafc8c78e9aee72e1";

    private final String CLIENT_SECRET = "715dc50e637f19afb9e2a76c3e41e2f118c54b0a";

    private final String CALLBACK_URL = "http://localhost:9527/user/oauth/github/callback";

    //获取用户的数据范围
    private final String AUTHORIZE_SCOPE = "user";

    //唯一标识
    protected final String AUTHORIZE_STATE = "Weleness_login";

    private final String REQUEST_AUTHORIZE_URL = "https://github.com/login/oauth/authorize?client_id="
            .concat(CLIENT_ID).concat("&redirect_uri=").concat(CALLBACK_URL).concat("&scope=").concat(AUTHORIZE_SCOPE)
            .concat("&state=").concat(AUTHORIZE_STATE);

    //请求token的地址 , code:是第一次同意授权后,github返回的一个code
    private final String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token?client_id="
            .concat(CLIENT_ID).concat("&client_secret=").concat(CLIENT_SECRET).concat("&code=%s")
            .concat("&redirect_uri=").concat(CALLBACK_URL).concat("&state=").concat(AUTHORIZE_STATE);


    //获取用户信息的api
    private final String USER_INFO_API_URL = "https://api.github.com/user?%s";

    @Override
    public String getRequestAuthorizeUrl() {
        return REQUEST_AUTHORIZE_URL;
    }

    @Override
    public ResultDTO callback(String state, String code, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
