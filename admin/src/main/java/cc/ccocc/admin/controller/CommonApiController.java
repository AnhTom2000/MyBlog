package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.admin.service.IAdminSuperAdminService;
import cc.ccocc.admin.service.IAdminUploadImgService;
import cc.ccocc.admin.service.IAdminVerifyCodeEmailService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.pojo.SupperAdmin;
import cc.ccocc.utils.result.ResultCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import static cc.ccocc.service.impl.AbstractOauthService.SIMPLE_COOKIE_KEY;

/**
 * Created on 21:42  12/02/2020
 * Description:
 *
 * @author Weleness
 */

@Controller
@RequestMapping("/admin/api")
public class CommonApiController {

    @Autowired
    @Qualifier("adminCookieService")
    @Lazy
    private IAdminCookieService cookieService;


    @ModelAttribute
    public void beforeToPage(Model model, HttpServletRequest request) {
        Cookie cookie = null;
        if((cookie = cookieService.getCookie("superAdmin",request))!=null){
            Object superAdmin = null;
            if((superAdmin = request.getSession().getAttribute(cookie.getValue()))!=null){
                model.addAttribute("superAdmin",superAdmin);
            }
        }
    }
    @Autowired
    @Qualifier("adminUploadImgService")
    private IAdminUploadImgService uploadUserImage;

    @ResponseBody
    @RequestMapping("/uploadUserImg")
    public AdminDTO uploadImgDTO(@RequestParam("admin_avatar") MultipartFile file, HttpServletRequest request,Model model) {
       AdminDTO result = null;
        if (model.getAttribute("superAdmin")!=null) {
          result =  uploadUserImage.uploadAdminImage(file,request);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }


}
