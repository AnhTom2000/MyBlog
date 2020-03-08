package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created on 16:52  10/02/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/admin")
public class JumpController {

    @Autowired
    @Qualifier("adminUserService")
    private IAdminUserService userService;

    @Autowired
    @Qualifier("adminArticleService")
    private IAdminArticleService articleService;

    @Autowired
    @Qualifier("adminTagService")
    private IAdminTagService tagService;

    @Autowired
    @Qualifier("adminSuperAdminService")
    private IAdminSuperAdminService adminSuperAdminService;


    @Autowired
    @Qualifier("adminCookieService")
    @Lazy
    private IAdminCookieService cookieService;

    @ModelAttribute
    public void beforeToPage(Model model, HttpServletRequest request) {
        Cookie cookie = null;
        if ((cookie = cookieService.getCookie("superAdmin", request)) != null) {
            Long superAdmin = null;
            if ((superAdmin = (Long) request.getSession().getAttribute(cookie.getValue())) != null) {
                model.addAttribute("superAdmin",adminSuperAdminService.findAdminById(superAdmin));
            }
        }
    }
    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        if (modelMap.getAttribute("superAdmin") != null) {
            modelMap.addAttribute("userCount", userService.userCount());
            modelMap.addAttribute("articleCount", articleService.articleCount());
            modelMap.addAttribute("tagCount", tagService.TagCount());
            modelMap.addAttribute("friendLinkCount", 1);
            modelMap.addAttribute("superAdmins",adminSuperAdminService.findAll(0,5));
            return "admin/index";
        } else return "admin/login";
    }

    @RequestMapping("/userAdmin")
    public String userAdmin(Model model) {
        if (model.getAttribute("superAdmin") != null)
            return "admin/userSetting";
        else return "admin/login";
    }

    @RequestMapping("/superAdmin")
    public String superAdmin(Model model) {
        if (model.getAttribute("superAdmin") != null)
            return "admin/manager";
        else return "admin/login";
    }

    @RequestMapping("/articleAdmin")
    public String articleAdmin(Model model) {
        if (model.getAttribute("superAdmin") != null)
            return "admin/articleManager";
        else return "admin/login";
    }

    @RequestMapping("/checkArticle")
    public String checkArticleAdmin(Model model) {
        if (model.getAttribute("superAdmin") != null)
            return "admin/checkArticle";
        else return "admin/login";
    }

    @RequestMapping("/questionAdmin")
    public String questionAdmin(Model model) {
        if (model.getAttribute("superAdmin") != null)
            return "admin/questionManager";
        else return "admin/login";
    }

    @RequestMapping("/commentAdmin")
    public String commentAdmin(Model model) {
        if (model.getAttribute("superAdmin") != null)
            return "admin/commentManager";
        else return "admin/login";
    }

    @RequestMapping("/messageAdmin")
    public String messageAdmin(Model model) {
        if(model.getAttribute("superAdmin")!=null)
        return "admin/msgManager";
        else return "admin/login";
    }

    @RequestMapping("/siteNotice")
    public String siteNoticeAdmin(Model model) {
        if(model.getAttribute("superAdmin")!=null)
        return "admin/siteNotice";
        else return "admin/login";

    }

    @RequestMapping("/friendLink")
    public String friendLinkAdmin(Model model) {
        if(model.getAttribute("superAdmin")!=null)
        return "admin/friendLink";
        else return "admin/login";
    }

    @RequestMapping("/meta")
    public String metaAdmin(Model model) {
        if(model.getAttribute("superAdmin")!=null)
        return "admin/meta";
        else return "admin/login";
    }

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }
}
