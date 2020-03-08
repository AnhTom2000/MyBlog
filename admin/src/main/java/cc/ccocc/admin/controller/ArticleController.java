package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.IAdminArticleService;
import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.User;
import cc.ccocc.service.ICookieService;
import cc.ccocc.utils.result.ResultCode;
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
import java.util.List;

/**
 * Created on 22:58  12/02/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @Autowired
    @Qualifier("adminArticleService")
    private IAdminArticleService articleService;

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

    @ResponseBody
    @RequestMapping("/findAll")
    public AdminDTO<List<Article>> findAll(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return articleService.findAllArticle((pageNo - 1) * pageSize, pageSize);
    }

    public AdminDTO<List<Article>> findAllUnchecked(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        return articleService.findAllArticle((pageNo - 1) * pageSize, pageSize);
    }

    @ResponseBody
    @RequestMapping("/search")
    public AdminDTO<List<Article>> search(@RequestParam("userName") String userName,@RequestParam("name") String articleTitle,@RequestParam("category") String categoryName){
        return articleService.searchArticle(userName, articleTitle, categoryName);
    }

    @ResponseBody
    @RequestMapping("/deleteArticles")
    public AdminDTO deleteUsers(Model model, @RequestParam(value = "articleId[]") Long[] articleIds) {
        AdminDTO result = null;
        if (model.getAttribute("superAdmin") != null) {
            result = articleService.deleteArticles(articleIds);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/findAllUnChecked")
    public AdminDTO<List<Article>> findAllUnChecked(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
            return articleService.findAllUnChecked((pageNo - 1) * pageSize, pageSize);
    }

    @ResponseBody
    @RequestMapping("/checkedArticle")
    public AdminDTO checkedArticle(@RequestParam("articleId")Long articleId,Model model){
        AdminDTO result = null;
        if (model.getAttribute("superAdmin") != null) {
            result = articleService.checkArticle(articleId);
        } else {
            result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(), "请先登陆", null, null, false);
        }
        return result;
    }
}
