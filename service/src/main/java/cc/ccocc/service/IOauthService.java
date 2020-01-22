package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 23:47  20/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IOauthService {

    public String getRequestAuthorizeUrl();

    public ResultDTO callback(String state, String code, HttpServletRequest request, HttpServletResponse response);

    public Oauth getOauthUserInfo(String state, String code);

    public UserDTO getUserByOauth(Oauth oauth);

    public boolean addOauth(Oauth oauth);

}
