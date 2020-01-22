package cc.ccocc.service.impl;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;
import cc.ccocc.utils.result.ResultCode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.sql.Time;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created on 23:49  20/01/2020
 * Description:
 *
 * @author Weleness
 */

@Service("githubOauthService")
public class GithubOauthServiceImpl extends AbstructOauthService {

    @Autowired
    @Qualifier("restTemplates")
    private RestTemplate restTemplate;

    //github客户端ID
    private final String CLIENT_ID = "39acafc8c78e9aee72e1";

    //github客户端 secret
    private final String CLIENT_SECRET = "b21f8a06084bead59cf3f1861931a68d3d717b7e";

    //回调url
    private final String REDIRECT_URL = "http://localhost:9527/user/oauth/github/callback";

    //获取用户的数据范围
    private final String AUTHORIZE_SCOPE = "user";

    private final String AUTHORIZE_STATE = "Weleness_login";

    //github请求授权地址
    private final String REQUEST_AUTHORIZE_URL = "https://github.com/login/oauth/authorize?client_id="
            .concat(CLIENT_ID).concat("&redirect_uri=").concat(REDIRECT_URL).concat("&scope=").concat(AUTHORIZE_SCOPE)
            .concat("&state=").concat(AUTHORIZE_STATE);

    //请求token的地址 , code:是第一次同意授权后,github返回的一个code
    private final String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token?client_id="
            .concat(CLIENT_ID).concat("&client_secret=").concat(CLIENT_SECRET).concat("&code=%s")
            .concat("&redirect_uri=").concat(REDIRECT_URL).concat("&state=").concat(AUTHORIZE_STATE);


    //获取用户信息的api
    private final String USER_INFO_API_URL = "https://api.github.com/user?%s";

    @Override
    public String getRequestAuthorizeUrl() {
        return REQUEST_AUTHORIZE_URL;
    }

    @Override
    public ResultDTO callback(String state, String code, HttpServletRequest request, HttpServletResponse response) {
        // 调用获取用户信息的方法
        Oauth userInfo = getOauthUserInfo(state, code);

        //获取用户在本平台信息
        UserDTO user = getUserByOauth(userInfo);

        if (userInfo == null) {
           throw new RuntimeException("获取用户信息失败");
        }
        ResultDTO result = null;
        //如果用户在本平台认证过
        if(user.getUserId() != null){
            // 存放用户的id
            request.getSession().setAttribute("user",user.getUserId());
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).status(true).build();
        }else {
            // 让用户完善信息
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).status(false).build();
        }

        return result;

    }

    @Override
    public Oauth getOauthUserInfo(String state, String code) {
        try {
            if (code == null) {
                throw new RuntimeException("用户的授权码获取失败!");
            }
            if (state == null) {
                throw new RuntimeException("用户登陆状态获取失败!");
            }
            // 获取请求返回的token                          // 请求的路径以及参数                   返回值类型
            String accessToken = restTemplate.getForObject(String.format(ACCESS_TOKEN_URL, code), String.class);
            if (accessToken == null) {
                throw new RuntimeException("用户请求认证失败！");
            }

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(String.format(USER_INFO_API_URL, accessToken));
            URI uri = builder.build().encode().toUri();

            String userInfo = restTemplate.getForObject(uri, String.class);
            if (userInfo == null) {
                throw new RuntimeException("获取用户信息失败！");
            }

            //生成一个uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //获取当前时间
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            // json 解析工具
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(userInfo);
            // 返回第三方登陆的用户信息
            return Oauth.builder().githubOpenId(jsonNode.path("id").asText()).oauthType(GITHUB_TYPE)
                    .qqOpenId(uuid).weChatOpenId(uuid)
                    .user(User.builder()
                            .userName(jsonNode.path("login").asText())
                            .avatarUrl(jsonNode.path("avatar_url").asText())
                            .gender(true).createTime(now).lastLogin(now).lastUpdate(now).build()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDTO getUserByOauth(Oauth oauth) {
        return userService.findUserByOauth(oauth);
    }




}
