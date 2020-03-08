package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.admin.service.IAdminSuperAdminService;
import cc.ccocc.admin.service.IAdminUserService;
import cc.ccocc.admin.service.IAdminVerifyCodeEmailService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.SupperAdmin;
import cc.ccocc.pojo.User;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

import static cc.ccocc.service.impl.AbstractOauthService.SIMPLE_COOKIE_KEY;

/**
 * Created on 18:18  12/02/2020
 * Description:
 *
 * @author Weleness
 */

@Controller
    @RequestMapping("/admin/superAdmin")
public class SuperAdminController {


    @Autowired
    @Qualifier("adminSuperAdminService")
    private IAdminSuperAdminService superAdminService;

    @Autowired
    @Qualifier("adminCookieService")
    private IAdminCookieService cookieService;


    @ModelAttribute
    public void beforeToPage(Model model,HttpServletRequest request) {
        Cookie cookie = null;
       if((cookie = cookieService.getCookie("superAdmin",request))!=null){
           Object superAdmin = null;
           if((superAdmin = request.getSession().getAttribute(cookie.getValue()))!=null){
               model.addAttribute("superAdmin",superAdmin);
           }
       }
    }
    @ResponseBody
    @RequestMapping("/login/cancel")
    public AdminDTO LoginCancel(@RequestParam("uuid") String uuid){
        return superAdminService.loginCancel(uuid);
    }
    /**
     * @Method Description:
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public AdminDTO<List<SupperAdmin>> findAllUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return superAdminService.findAll((pageNo - 1) * pageSize, pageSize);
    }

    /**
     * @Method Description:
     * 添加新用户
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public AdminDTO<List<SupperAdmin>> addNewUser(Model model,
                                                  @NotBlank(message = "用户名不能为空")
                                                  @RequestParam("userName") String username,

                                                  @NotBlank(message = "密码不能为空")
                                                  @RequestParam("password") String password,

                                                  @NotBlank(message = "年龄不能为空")
                                                  @Pattern(regexp = "[0-9]+", message = "年龄必须是纯数字")
                                                  @RequestParam("age") Short age,

                                                  @NotBlank(message = "性别不能为空")
                                                  @RequestParam("gender") Boolean gender,

                                                  @NotBlank(message = "邮箱不能为空")
                                                  @Length(max = 20, message = "邮箱最多不能超过20个字符")
                                                  @Email(message = "邮箱格式不正确")
                                                  @RequestParam("email") String email
    ) {
        AdminDTO<List<SupperAdmin>> result = null;
        if (model.getAttribute("superAdmin") != null) {
            result = superAdminService.addAdmin(username, password, age, gender, email);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/updateUser")
    public AdminDTO<SupperAdmin> updateUser(Model model,
                                            @NotBlank(message = "用户id不能为空")
                                            @RequestParam("adminId") Long adminId,
                                            @Email(message = "邮箱格式不正确")
                                            @Length(max = 20, message = "邮箱最多不能超过20个字符")
                                            @RequestParam("email") String email,
                                            @NotBlank(message = "手机不能为空")
                                            @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$", message = "手机号必须正确")
                                            @Length(max = 13, message = "手机号不能超过13位")
                                            @RequestParam("phone") String phone,
                                            @NotBlank(message = "性别不能为空")
                                            @RequestParam("gender") Boolean gender
            , @RequestParam("avatarUrl") String avatarUrl) {
        AdminDTO<SupperAdmin> result = null;
        if (model.getAttribute("superAdmin") != null) {
            result = superAdminService.updateAdmin(adminId, email, phone, gender, avatarUrl);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteAdmins")
    public AdminDTO deleteUsers(Model model, @RequestParam(value = "select[]") Long[] adminIds) {
        AdminDTO result = null;
        if (model.getAttribute("superAdmin") != null) {
            result = superAdminService.deleteAdmins(adminIds);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }



    @ResponseBody
    @RequestMapping("/search")
    public AdminDTO<List<SupperAdmin>> searchUser(@RequestParam(value = "adminId", required = false) Long adminId, @RequestParam(value = "adminName", required = false) String adminName, @Email(regexp = "/^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/", message = "邮箱格式不正确") @RequestParam(value = "email", required = false) String email) {
        return superAdminService.searchAdmin(adminId, adminName, email);
    }


    @ResponseBody
    @RequestMapping("/sendToUser")
    public AdminDTO sendToUser(@RequestParam("userId") Long userId,@RequestParam("content") String content,Model model){
        AdminDTO result = null;
        if(model.getAttribute("superAdmin")!= null){
            result = superAdminService.sendToUser(userId, content);
        }else {
           result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(),"请先登陆",null,null,false);
        }
        return  result;
    }


    @ResponseBody
    @RequestMapping("/login/adminLogin")
    public AdminDTO login(@Pattern(regexp = "^\\D+?.*$", message = "用户名不能以数字开头")
                              @Length(max = 20, message = "用户名长度必须在1-20位之间")
                              @NotBlank(message = "用户名不能为空")
                              @RequestParam("username") String adminName,

                          @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$", message = "密码必须由7-20位大小写英文字母,数字(允许中文和特殊字符)组成")
                              @NotBlank(message = "密码不能为空")
                              @RequestParam("password") String password){
            return superAdminService.SuperAdminLogin(adminName, password);
    }

    @ResponseBody
    @RequestMapping("/login/check")
    public AdminDTO checkVerifyCode(@RequestParam("uuid") String uuid,HttpServletRequest request,HttpServletResponse response , @RequestParam("verifyCode") String verifyCode,@RequestParam("adminId") Long adminId){
        return superAdminService.check(uuid,verifyCode,adminId, request, response);
    }

    /**
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @Method Description:
     * 退出方法
     * @Author weleness
     * @Return
     */
    @RequestMapping("/exit/adminExit")
    @ResponseBody
    public AdminDTO exit(HttpServletRequest request, HttpServletResponse response) {
        AdminDTO result = null;
        try {
            cookieService.removeCookie(cookieService.getCookie("superAdmin", request), response);
            result = new  AdminDTO<>(ResultCode.OK_CODE.getCode(),"退出成功",null,null,true);
        } catch (Exception e) {
            result = new  AdminDTO<>(ResultCode.CLIENT_ERROR_CODE.getCode(),"操作失败",null,null,false);
        }
        return result;
    }
}
