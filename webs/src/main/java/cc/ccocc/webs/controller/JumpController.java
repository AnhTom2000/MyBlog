package cc.ccocc.webs.controller;


import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static cc.ccocc.service.impl.AbstructOauthService.*;


/**
 * Created on 22:04  17/01/2020
 * Description:
 * 跳转路由
 *
 * @author Weleness
 */

@Controller
public class JumpController {
    @Autowired
    @Qualifier("articleService")
    private IArticleService articleService;
    @Autowired
    @Qualifier("tagService")
    private ITagService tagService;
    @Autowired
    @Qualifier("categoryService")
    private ICategoryService categoryService;
    @Autowired
    @Qualifier("archiveService")
    private IArchiveService archiveService;

    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    @Qualifier("article_userService")
    private IArticle_UserService article_userService;


    // 这个方法会在其他请求控制器方法调用之前被调用，来完成主要的数据存入
    @ModelAttribute
    public void beforePage(Model model, HttpServletRequest request) {
        Cookie userCookie = null;
        UserDTO userDTO = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            System.out.println(userId);
            userDTO = userService.findUserById(userId);
        }


        if (userDTO != null) model.addAttribute("user", userDTO);
        model.addAttribute("article_List", articleService.findAll());
        model.addAttribute("tag_List", tagService.findAll());
        model.addAttribute("article_new_List", articleService.findArticleNew());
        model.addAttribute("article_count", articleService.article_Count());
        model.addAttribute("tag_count", tagService.tag_Count());
        model.addAttribute("category_List", categoryService.findAll());
        model.addAttribute("archive_List", archiveService.findArchives());
    }

    /**
     * @Method Description:
     * 主页路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/")
    public String main(Model model) {
        return "main";
    }


    /**
     * @Method Description:
     * 归档路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/archives")
    public String archives(Model model) {
        return "archives";
    }

    /**
     * @Method Description:
     * markdown编辑器路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/markdown")
    public String markdown(Model model) {
        return "markdown";
    }

    /**
     * @Method Description:
     * 富文本编辑器路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/rich")
    public String rich(Model model) {
        return "rich";
    }

    /**
     * @Method Description:
     * 登陆路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * @Method Description:
     * 注册路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }

    /**
     * @Method Description:
     * 用户完善信息页路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/oauth/information/complete")
    public String informationComplete() {
        return "oauth_Information";
    }

    @RequestMapping("/article/{articleId}")
    public String article(@PathVariable("articleId") String articleId,Model model,HttpServletRequest request){
        UserDTO userDTO= null;
        if((userDTO = (UserDTO) model.getAttribute("user"))!=null){
            ResultDTO resultDTO = article_userService.checkArticleIsLikeByUser(Long.parseLong(articleId), userDTO.getUserId());
            //如果用户点赞过这篇文章
            if(resultDTO.isStatus()){
                model.addAttribute("isLike","isLike");
                model.addAttribute("heart","heart");
            }
        }
        model.addAttribute("article_info",articleService.findArticleById(Long.parseLong(articleId)));
        return "article";
    }



}
