package cc.ccocc.admin.controller;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.admin.service.IAdminUserService;
import cc.ccocc.pojo.User;
import cc.ccocc.utils.result.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created on 21:40  10/02/2020
 * Description:
 *
 * @author Weleness
 */

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    @Qualifier("adminUserService")
    private IAdminUserService adminUserService;

    @ModelAttribute
    public void beforeToPage(Model model) {
        model.addAttribute("user", "1");
    }

    /**
     * @Method Description:
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/user/findAll")
    public AdminDTO<List<User>> findAllUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return adminUserService.findAllUser((pageNo - 1) * pageSize, pageSize);
    }

    /**
     * @Method Description:
     * 添加新用户
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/user/addUser")
    public AdminDTO<List<User>> addNewUser(Model model,
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
        AdminDTO<List<User>> result = null;
        if (model.getAttribute("user") != null) {
            result = adminUserService.addUser(username, password, age, gender, email);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/user/updateUser")
    public AdminDTO<User> updateUser(Model model,
                                     @NotBlank(message = "用户id不能为空")
                                     @RequestParam("userId") Long userId,
                                     @Email(message = "邮箱格式不正确")
                                     @Length(max = 20, message = "邮箱最多不能超过20个字符")
                                     @RequestParam("email") String email,
                                     @NotBlank(message = "手机不能为空")
                                     @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\\\d{8}$", message = "手机号必须正确")
                                     @Length(max = 13, message = "手机号不能超过13位")
                                     @RequestParam("phone") String phone,
                                     @NotBlank(message = "性别不能为空")
                                     @RequestParam("gender") Boolean gender) {
        AdminDTO<User> result = null;
        if (model.getAttribute("user") != null) {
            result = adminUserService.updateUser(userId, email, phone, gender);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/user/deleteUsers")
    public AdminDTO<User> deleteUsers(Model model, @RequestParam(value = "select[]") Long[] userIds) {
        AdminDTO<User> result = null;
        if (model.getAttribute("user") != null) {
            result = adminUserService.deleteUsers(userIds);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/user/search")
    public AdminDTO<List<User>> searchUser(@RequestParam(value = "userId", required = false) Long userId, @RequestParam(value = "name", required = false) String userName, @Email(regexp = "/^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$/", message = "邮箱格式不正确") @RequestParam(value = "email", required = false) String email) {
        return adminUserService.searchUser(userId, userName, email);
    }

    @ResponseBody
    @RequestMapping("/user/locked")
    public AdminDTO lockedUser(@RequestParam("userId") Long userId,@RequestParam("type") String type,Model model){
        AdminDTO result = null;
        if (model.getAttribute("user") != null) {
            result = adminUserService.lockedUser(userId,type);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }


}

