package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IOauthService;
import cc.ccocc.service.IUserService;
import cc.ccocc.service.IVerifyCodeEmailService;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

    private final  Long timeOut = 120L;

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
    @RequestMapping("/check/user/{username}/exist")
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
    @RequestMapping("/check/email/{email}/exist")
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
    @RequestMapping("/send/email/{email}/checkCode")
    public ResultDTO sendCheckCode(@Length(max = 50, message = "邮箱长度不能超过五十个字符")
                                   @Email(message = "邮箱格式不正确")
                                   @NotBlank(message = "邮箱不能为空")
                                   @PathVariable("email") String email) {
        return verifyCodeEmailService.sendEmailWithVerifyCode(email,timeOut);
    }


}
