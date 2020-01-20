package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;

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


}
