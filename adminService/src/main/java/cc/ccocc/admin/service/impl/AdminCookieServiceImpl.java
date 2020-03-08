package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.service.ICookieService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created on 11:21  23/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminCookieService")
public class AdminCookieServiceImpl implements IAdminCookieService {

    private final Integer TIME_OUT = 86400;



    @Override
    public Cookie generateCookie(String key) {
        if(key == null)
        {
            return null;
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Cookie cookie = new Cookie(key,uuid );
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(TIME_OUT);
        return cookie;
    }

    @Override
    public void removeCookie(Cookie cookie, HttpServletResponse response) {
        if(cookie != null) {
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    @Override
    public Cookie getCookie(String key, HttpServletRequest request) {
        if(request.getCookies() != null && key != null)
        {
            for (Cookie cookie : request.getCookies())
            {
                if(cookie.getName().endsWith(key))
                {
                    return cookie;
                }

            }
        }
        return null;
    }
}
