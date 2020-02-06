package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.User;
import cc.ccocc.service.*;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ICookieService cookieService;

    /**
     * @Method Description:
     * 用户通过邮箱修改密码
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/modify/password")
    public ResultDTO modifyUserPassword(
            @NotBlank(message = "密码不能为空")
            @RequestParam("modifyPassword") String modifyPassword,

            @Length(max = 50, message = "邮箱长度不能超过50")
            @Email(message = "邮箱格式不正确")
            @NotBlank(message = "邮箱不能为空")
            @RequestParam("email") String email,

            @Pattern(regexp = "^\\d{6}$", message = "验证码不正确")
            @NotBlank(message = "验证码不能为空")
            @RequestParam("verificationCode") String verificationCode,
            HttpServletRequest request,

            HttpServletResponse response
    ) {
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                result =   userService.updateUserPassword(userId,email,verificationCode,modifyPassword);
            } else {
                result = new ResultDTO(ResultCode.CLIENT_ERROR_CODE.getCode(), "请先登陆", false);
            }
        }
        return result;
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
    @ResponseBody
    @RequestMapping("/modify/savePersonalUpdate")
    public ResultDTO savePersonalUpdate(
            @Pattern(regexp = "[0-9]+", message = "年龄必须是纯数字")
            @RequestParam("age") short age,

            @NotBlank(message = "性别不能为空")
            @RequestParam("gender") boolean gender,

            @Length(max = 50, message = "邮箱不能超过50位")
            @Email(message = "邮箱格式不正确")
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
            @RequestParam("description") String description, HttpServletRequest request) {
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                result = userService.savePersonalUpdate(userId, email, age, gender, area, phone, description, profession);
            } else {
                result = new ResultDTO(ResultCode.CLIENT_ERROR_CODE.getCode(), "请先登陆", false);
            }
        }
        return result;
    }


}
