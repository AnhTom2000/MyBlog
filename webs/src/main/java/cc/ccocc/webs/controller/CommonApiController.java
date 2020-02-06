package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.service.*;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static cc.ccocc.service.impl.AbstractOauthService.*;

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

    @Autowired
    @Qualifier("uploadArticleImgService")
    private IUploadImg uploadArticleImg;

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
     * @param username 用户名
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
     * @param email 用户邮箱
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
     * @param request HttpServletRequest
     * @Method Description:
     * 检查用户是否登陆
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/check/user/isLogin")
    public ResultDTO isLogin(HttpServletRequest request) {
        Cookie userCookie = null;
        UserDTO userDTO = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                return ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("已登录").status(true).build();
            } else return ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("还未登陆").status(false).build();
        }
        return ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("还未登陆").status(false).build();
    }

    /**
     * @param email 用户邮箱
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

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @Method Description:
     * 退出方法
     * @Author weleness
     * @Return
     */
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

    /**
     * @param articleId 文章主键
     * @Method
     * Description:
     *  文章访问量统计接口
     * @Author weleness
     *
     * @Return
     */
    @ResponseBody
    @RequestMapping("/article/visitorComing")
    public ResultDTO addArticleViewStatistics(@RequestParam("articleId") String articleId) {
        return articleService.addArticleViewStatistics(Long.parseLong(articleId));
    }


    /* 考虑到解耦的关系，一个接口只能对应一个方法，一个接口只能处理一个请求，所以，要分开成两个接口
     *   即一个上传图片接口和一个上传用户头像的接口
     * */

    /**
     * @param file 文章上传图片的数据
     * @param request HttpServletRequest
     * @Method Description:
     * 写文章的时候上传图片的接口
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadArticleImg", produces = "application/json;charset=utf-8")
    public UploadImgDTO uploadImg(@RequestParam(value = "editormd-image-file") MultipartFile file, HttpServletRequest request) {
        UploadImgDTO uploadImgDTO = null;
        Cookie userCookie = null;

        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null && (request.getSession().getAttribute(userCookie.getValue())) != null) {
            uploadImgDTO = uploadArticleImg.uploadArticleImage(file, request);
        } else {
            uploadImgDTO = UploadImgDTO.builder().message("请先登陆").success(0).url("").build();
        }
        return uploadImgDTO;
    }

    /**
     * @param file 用户头像的数据
     * @param request  HttpServletRequest
     * @Method
     * Description:
     *  用户上传头像的接口
     * @Author weleness
     *
     * @Return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadUserImg", produces = "application/json;charset=utf-8")
    public UploadImgDTO uploadImgDTO(@RequestParam("user_avatar") MultipartFile file, HttpServletRequest request) {
        UploadImgDTO uploadImgDTO = null;
        Cookie userCookie = null;
        Long userId = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null && (userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
            uploadImgDTO = uploadArticleImg.uploadUserImage(file, request, userId);
        } else {
            uploadImgDTO = UploadImgDTO.builder().message("请先登陆").success(0).url("").build();
        }
        return uploadImgDTO;
    }

}
