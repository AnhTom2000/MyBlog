package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IOauthService;
import cc.ccocc.service.IUserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Created on 23:34  20/01/2020
 * Description:
 * 用户登陆认证接口
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/user")
public class AuthenticationController {

    //第三方认证服务
    @Autowired
    @Qualifier("githubOauthService")
    private IOauthService githubOAuthService;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    /**
     * @param code  用户请求认证成功后返回的授权码
     * @param state 用户请求的状态
     * @return ResultDTO
     * @Method Description:
     * github回调接口
     * @Author weleness
     */
    @RequestMapping("/oauth/github/callback")
    public ModelAndView githubOauthCallback(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        // 如果用户在本平台登陆过了
        if (!githubOAuthService.callback(state, code, request, response).isStatus()) {
            // 直接跳转至主页
            mv.setViewName("redirect:/oauth/information/complete");
        } else {
            // 否则完善信息
            mv.setViewName("redirect:/");
        }
        return mv;
    }

    /**
     * @param email            用户注册的邮箱  邮箱可以相同
     * @param verificationCode 用户的验证码
     * @Method Description:
     * 用户信息完善
     * @Author weleness
     * @Return
     */
    @RequestMapping("/oauth/information/complete")
    @ResponseBody
    public ResultDTO oauthInformationComplete(@Pattern(regexp = "^\\D+?.*$", message = "用户名不能以数字开头")
                                              @Length(max = 20, message = "用户名长度必须在1-20位之间")
                                              @NotBlank(message = "用户名不能为空")
                                              @RequestParam("username") String username,

                                              @Length(max = 50, message = "邮箱格式不能超过五十位")
                                              @Email(message = "邮箱格式不正确")
                                              @NotBlank(message = "邮箱不能为空")
                                              @RequestParam("email") String email,

                                              @Pattern(regexp = "^\\d{6}$", message = "验证码不正确")
                                              @NotBlank(message = "验证码不能为空")
                                              @RequestParam("verificationCode") String verificationCode,

                                              HttpServletRequest request,

                                              HttpServletResponse response) {
        System.out.println(username);
        System.out.println(email);
        System.out.println(verificationCode);

        return userService.oauthInformationComplete(username, email, verificationCode, request, response);
    }


    /**
     * @param username 用户名
     * @param password 密码
     * @Method Description:
     * 用户登陆接口
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/login")
    public ResultDTO login(@Pattern(regexp = "^\\D+?.*$", message = "用户名不能以数字开头")
                           @Length(max = 20, message = "用户名长度必须在1-20位之间")
                           @NotBlank(message = "用户名不能为空")
                           @RequestParam("username") String username,

                           @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$", message = "密码必须由7-20位大小写英文字母,数字(允许中文和特殊字符)组成")
                           @NotBlank(message = "密码不能为空")
                           @RequestParam("password") String password,
                           HttpServletRequest request,

                           HttpServletResponse response) {
        return userService.login(username, password,request,response);
    }

    /**
     * @param email    用户邮箱
     * @param username 用户名
     * @param password 密码
     * @Method Description:
     * 用户注册接口
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/register")
    public ResultDTO register(@Pattern(regexp = "^\\D+?.*$", message = "用户名不能以数字开头")
                              @Length(max = 20, message = "用户名长度必须在1-20位之间")
                              @NotBlank(message = "用户名不能为空")
                              @RequestParam("username") String username,

                              @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$", message = "密码必须由7-20位大小写英文字母,数字(允许中文和特殊字符)组成")
                              @NotBlank(message = "密码不能为空")
                              @RequestParam("password") String password,

                              @Length(max = 50, message = "邮箱不能超过50个字符")
                              @Email(message = "邮箱格式不正确")
                              @NotBlank(message = "邮箱不能为空")
                              @RequestParam("email") String email,

                              @Pattern(regexp = "^\\d{6}$", message = "验证码不正确")
                              @NotBlank(message = "验证码不能为空")
                              @RequestParam("verificationCode") String verificationCode,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        System.out.println(username);
        return userService.register(username, email, password, verificationCode,request,response);
    }

}
