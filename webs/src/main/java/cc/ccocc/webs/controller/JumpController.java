package cc.ccocc.webs.controller;


import cc.ccocc.dto.*;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Tag;
import cc.ccocc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

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

    @Autowired
    private ICommentService commentService;

    @Autowired
    @Qualifier("allCountService")
    private IAllCountService allCountService;

    // 这个方法会在其他请求控制器方法调用之前被调用，来完成主要的数据存入
    @ModelAttribute
    public void beforePage(Model model, HttpServletRequest request) {
        Cookie userCookie = null;
        UserDTO userDTO = null;
        List<ArticleDTO> userArticle = null;
        List<CommentDTO> newComment = null;
        List<ArchiveDTO> archives = null;
        List<Article> userNewArticle = null;
        List<Tag> userTag = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
           if(userId != null){
               userDTO = userService.findUserById(userId);
               // 根据用户id去查用户的相关信息
               userArticle =  articleService.findArticleByUserId(userId);
               // 根据用户id去查属于用户的文章的评论
               newComment = commentService.getNewsComment(userId);
               // 根据用户的id去查属于用户的文章归档
               archives = archiveService.findArchives(userId);
                // 根据用户id查找对应的最新文章
               userNewArticle = articleService.findArticleNewByUserId(userId);

               userTag = tagService.findTagByUserId(userId);
           }
        }
        if (userDTO != null){
            model.addAttribute("user", userDTO);
        }
        if(userArticle!=null){
            model.addAttribute("userArticles",userArticle);
        }
        if(newComment!= null){
            model.addAttribute("newComments",newComment);
        }
        if(archives != null) {
            model.addAttribute("archive_List", archives);
        }
        if(userNewArticle != null){
            model.addAttribute("article_new_List",userArticle);
        }
        if(userTag != null){
            model.addAttribute("user_tag",userTag);
        }
        model.addAttribute("article_new_List", articleService.findAllArticleNew());
        model.addAttribute("allCounts",allCountService.getAllCount());
        model.addAttribute("tag_List", tagService.findAll());
        model.addAttribute("article_List", articleService.findAll());
        model.addAttribute("category_List", categoryService.findAll());
    }

    /**
     * @Method Description:
     * 主页路由,由首页展示所有的文章
     * @Author weleness
     * @Return
     */
    @RequestMapping("/")
    public String main(Model model) {

        return "location";
    }

    /**
     * @Method
     * Description:
     *  用户完成信息完善，跳转到主页路由
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/complete")
    public ModelAndView complete(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/");
        return mv;
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

    @RequestMapping("/userSystem")
    public String userSystem(){return "admin/userEdit";}

    @RequestMapping("/userMain")
    public String userMain(){return "user";}



    @RequestMapping("/article/{articleId}")
    public String article(@PathVariable("articleId") String articleId,Model model,HttpServletRequest request){
        UserDTO userDTO= null;
        model.addAttribute("article_info",articleService.findArticleById(Long.parseLong(articleId)));
        if((userDTO = (UserDTO) model.getAttribute("user"))!=null){
            ResultDTO resultDTO = article_userService.checkArticleIsLikeByUser(Long.parseLong(articleId), userDTO.getUserId());
            //如果用户点赞过这篇文章
            if(resultDTO.isStatus()){
                model.addAttribute("isLike","isLike");
                model.addAttribute("heart","heart");
            }
        }

        return "article";
    }



}
