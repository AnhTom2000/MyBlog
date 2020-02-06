package cc.ccocc.service.impl;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 17:28  21/01/2020
 * Description:
 *  qq授权服务接口的实现类
 * @author Weleness
 */
@Service("qqOauthService")
public class QqOauthServiceImpl extends AbstractOauthService {

    @Override
    public String getRequestAuthorizeUrl() {
        return super.getRequestAuthorizeUrl();
    }

    @Override
    public ResultDTO callback(String state, String code, HttpServletRequest request, HttpServletResponse response) {
        return super.callback(state, code, request, response);
    }

    @Override
    public Oauth getOauthUserInfo(String state, String code) {
        return super.getOauthUserInfo(state, code);
    }

    @Override
    public UserDTO getUserByOauth(Oauth oauth) {
        return super.getUserByOauth(oauth);
    }


}
