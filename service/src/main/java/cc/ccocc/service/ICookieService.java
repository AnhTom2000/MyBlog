package cc.ccocc.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 11:18  23/01/2020
 * Description:
 *
 * @author Weleness
 */
public interface ICookieService {

    public Cookie generateCookie(String key );

    public void  removeCookie(Cookie cookie, HttpServletResponse response);

    public Cookie getCookie(String key,HttpServletRequest request);
}
