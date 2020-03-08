package cc.ccocc.webs.controller;

import cc.ccocc.annotation.Action;
import cc.ccocc.annotation.BeforeSth;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.*;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static cc.ccocc.service.impl.AbstractOauthService.SIMPLE_COOKIE_KEY;

/**
 * Created on 17:00  22/01/2020
 * Description:
 *
 * @author Weleness
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Autowired
    @Qualifier("questionService")
    private IQuestionService questionService;

    /**
     * @Method Description:
     * 用户通过邮箱修改密码
     * @Author weleness
     * @Return
     */
    @Action("modifyPassword")
    @ResponseBody
    @RequestMapping("/modify/password")
    public ResultDTO modifyUserPassword(
            @NotBlank(message = "密码不能为空")
            @RequestParam("modifyPassword") String modifyPassword,

            @Length(max = 50, message = "邮箱长度不能超过50")
            @Email(regexp = "/^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/", message = "邮箱格式不正确")
            @NotBlank(message = "邮箱不能为空")
            @RequestParam("email") String email,

            @Pattern(regexp = "^\\d{6}$", message = "验证码不正确")
            @NotBlank(message = "验证码不能为空")
            @RequestParam("verificationCode") String verificationCode,
            HttpServletRequest request, HttpSession session,HttpServletResponse response) {
        return userService.updateUserPassword((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), email, verificationCode, modifyPassword,request,response);
    }

    /**
     * @param email       用户邮箱
     *                    --------------------以下为选填项
     * @param age         用户名年龄
     * @param gender      用户性别
     * @param area        用户地区
     * @param phone       用户手机号
     * @param description 用户个人简介
     * @param profession  工作
     * @Method Description:
     * 修改用户信息操作
     * @Author weleness
     * @Return
     */
    @Action("personalUpdate")
    @ResponseBody
    @RequestMapping("/modify/savePersonalUpdate")
    public ResultDTO savePersonalUpdate(
            @Pattern(regexp = "[0-9]+", message = "年龄必须是纯数字")
            @RequestParam("age") short age,

            @NotBlank(message = "性别不能为空")
            @RequestParam("gender") boolean gender,

            @Length(max = 50, message = "邮箱不能超过50位")
            @Email(regexp = "/^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/", message = "邮箱格式不正确")
            @NotBlank(message = "邮箱不能为空")
            @RequestParam("email") String email,

            @NotBlank(message = "地区不能为空")
            @RequestParam("area") String area,

            @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$", message = "手机号必须正确")
            @Length(max = 13, message = "手机号不能超过13位")
            @RequestParam("phone") String phone,

            @NotBlank(message = "职业不能为空")
            @RequestParam("profession") String profession,

            @NotBlank(message = "个人简介不能为空")
            @RequestParam("description") String description, HttpServletRequest request, HttpSession session) {

        return userService.savePersonalUpdate((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), email, age, gender, area, phone, description, profession);
    }

    @BeforeSth
    @ResponseBody
    @RequestMapping("/question/submitFeedback")
    public ResultDTO feedback(@RequestParam("feedBackTitle") String feedBackTitle, @RequestParam("feedBackContent") String feedBackContent, HttpServletRequest request,HttpSession session) {
        return questionService.addQuestion((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY,request).getValue()), feedBackTitle, feedBackContent);
    }

}
