package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IUserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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

    /**
     * @Method Description:
     * 用户通过邮箱修改密码
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/modify/password")
    public ResultDTO modifyUserPassword(
            @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$", message = "密码必须由7-20位大小写英文字母,数字(允许中文和特殊字符)组成")
            @NotBlank(message = "密码不能为空")
            @RequestParam("modifyPassword") String modifyPassword,

            @Length(max = 50, message = "邮箱长度不能超过50")
            @Email(message = "邮箱格式不正确")
            @NotBlank(message = "邮箱不能为空")
            @RequestParam("email") String email) {

        return null;
    }

}
