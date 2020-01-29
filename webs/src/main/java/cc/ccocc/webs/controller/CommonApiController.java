package cc.ccocc.webs.controller;

import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.service.*;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static cc.ccocc.service.impl.AbstructOauthService.*;

/**
 * Created on 10:29  21/01/2020
 * Description:
 *
 * @author Weleness
 */

@RequestMapping("/api")
@Controller
public class CommonApiController {

    @Autowired
    @Qualifier("githubOauthService")
    private IOauthService githubOauthService;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    @Qualifier("verifyCodeEmailService")
    private IVerifyCodeEmailService verifyCodeEmailService;

    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Autowired
    @Qualifier("articleService")
    private IArticleService articleService;

    private final Long timeOut = 120L;


    /**
     * @Method Description:
     * 请求github的登陆网址
     * @Author weleness
     * @Return
     */
    @RequestMapping("/authorize_url/github")
    @ResponseBody
    public ResultDTO oauth() {
        return new ResultDTO(ResultCode.OK_CODE.getCode(), githubOauthService.getRequestAuthorizeUrl(), true);
    }

    /**
     * @Method Description:
     * 检查用户名是否重复注册
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @GetMapping("/check/user/{username}/exist")
    public ResultDTO checkUserName(@Length(max = 50, message = "用户名长度不能超过50个字符")
                                   @NotBlank(message = "用户名不能为空")
                                   @PathVariable("username") String username
    ) {
        return userService.checkUserExsitByName(username);
    }

    /**
     * @Method Description:
     * 检查邮箱是否重复注册
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @GetMapping("/check/email/{email}/exist")
    public ResultDTO checkEmailExist(@Length(max = 50, message = "邮箱长度不能超过五十个字符")
                                     @Email(message = "邮箱格式不正确")
                                     @NotBlank(message = "邮箱不能为空")
                                     @PathVariable("email") String email) {

        return userService.checkUserExsitByEmail(email);
    }


    /**
     * @Method Description:
     * 根据邮箱发送验证码
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @GetMapping("/send/email/{email}/checkCode")
    public ResultDTO sendCheckCode(@Length(max = 50, message = "邮箱长度不能超过五十个字符")
                                   @Email(message = "邮箱格式不正确")
                                   @NotBlank(message = "邮箱不能为空")
                                   @PathVariable("email") String email) {
        return verifyCodeEmailService.sendEmailWithVerifyCode(email, timeOut);
    }

    @RequestMapping("/exit/userExit")
    @ResponseBody
    public ResultDTO exit(HttpServletRequest request, HttpServletResponse response) {
        ResultDTO result = null;
        try {
            cookieService.removeCookie(cookieService.getCookie(SIMPLE_COOKIE_KEY, request), response);
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("退出成功").status(true).build();
        } catch (Exception e) {
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("操作失败").status(false).build();
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/article/visitorComing")
    public ResultDTO addArticleViewStatistics(@RequestParam("articleId") String articleId){
        return articleService.addArticleViewStatistics(Long.parseLong(articleId));
    }


}
