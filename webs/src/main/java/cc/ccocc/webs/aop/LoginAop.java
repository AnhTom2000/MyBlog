package cc.ccocc.webs.aop;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.exception.LoginException;
import cc.ccocc.service.ICookieService;
import cc.ccocc.utils.result.ResultCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Objects;

import static cc.ccocc.service.impl.AbstractOauthService.*;

/**
 * Created on 15:26  23/02/2020
 * Description:
 *
 * @author Weleness
 */
@Aspect
@Component
public class LoginAop {
    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Pointcut("@annotation(cc.ccocc.annotation.Action)")
    public void login() {
    }

    @Pointcut("@annotation(cc.ccocc.annotation.BeforeSth)")
    public void artilceDST(){}

    @Around("artilceDST()")
    public Object principalAround(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Object[] args = pjp.getArgs();
        Cookie cookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request);
        ResultDTO result = null;
        if (cookie == null) {
           result  = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("请先登陆").status(false).build();
        } else {
            HttpSession session = request.getSession();
            if((session.getAttribute(cookie.getValue())) == null){
                //if(pjp.getSignature())
               result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("请先登陆").status(false).build();
            }else {
               return  pjp.proceed(args);
            }
        }
        return result;
    }
    @Before("login()")
    public void dstBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Cookie cookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request);

        if (cookie == null) {
            throw new LoginException("请先登录");
        } else {
            HttpSession session = request.getSession();
           if((session.getAttribute(cookie.getValue())) == null){
               throw new LoginException("请先登录");
           }
        }
    }
}
