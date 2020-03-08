package cc.ccocc.webs.controller;


import cc.ccocc.annotation.Action;
import cc.ccocc.dto.*;
import cc.ccocc.exception.NoFundException;
import cc.ccocc.pojo.Tag;
import cc.ccocc.pojo.User;
import cc.ccocc.service.*;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static cc.ccocc.service.impl.AbstractOauthService.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


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
    @Qualifier("allCountService")
    private IAllCountService allCountService;

    @Autowired
    @Qualifier("siteNoticeService")
    private ISiteNoticeService siteNoticeService;

    @Autowired
    @Qualifier("webInfoService")
    private IWebInfoService webInfoService;

    @Autowired
    @Qualifier("questionService")
    private IQuestionService questionService;

    // 这个方法会在其他请求控制器方法调用之前被调用，来完成主要的数据存入
    @ModelAttribute
    public void beforePage(Model model, HttpServletRequest request) {
        Cookie userCookie = null;
        UserDTO userDTO = null;
        model.addAttribute("webInfo", webInfoService.WebInfo());
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                userDTO = userService.findUserById(userId);
            }
        }
        if (userDTO != null) {
            model.addAttribute("user", userDTO);
        }
        // 集合去重
        List<Tag> tagList = tagService.findAll().stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(Tag::getTag_name))), ArrayList::new)
        );
        model.addAttribute("article_new_List", articleService.findAllArticleNew());
        model.addAttribute("allCounts", allCountService.getAllCount());
        model.addAttribute("tag_List", tagList);
        model.addAttribute("category_List", categoryService.findAll());
    }

    /**
     * @Method Description:
     * 主页路由,由首页展示所有的文章
     * @Author weleness
     * @Return
     */
    @RequestMapping({"/", "home"})
    public String main(Model model, @RequestParam(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        model.addAttribute("siteNotice", siteNoticeService.findAll());
        model.addAttribute("pageHelper", articleService.findAll(pageNo, pageSize));
        model.addAttribute("feedBackCount", questionService.questionCount());
        return "location";
    }

    /**
     * @Method Description:
     * 用户完成信息完善，跳转到主页路由
     * @Author weleness
     * @Return
     */
    @RequestMapping("/complete")
    public ModelAndView complete() {
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
        model.addAttribute("archives", archiveService.findAllArchives());
        return "archives";
    }

    /**
     * @Method Description:
     * markdown编辑器路由
     * @Author weleness
     * @Return
     */
    @Action("markdown")
    @RequestMapping("/markdown")
    public String markdown(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("user_tag", tagService.findTagByUserId((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue())));
        return "markdown";
    }

    @RequestMapping("/update")
    public String update(Model model, HttpServletRequest request) {
        model.addAttribute("article_info", articleService.findArticleById(2593888569894506496L));
        Long userId = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            if ((userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
                ResultDTO resultDTO = article_userService.checkArticleIsLikeByUser(2593888569894506496L, userId);
                //如果用户点赞过这篇文章
                if (resultDTO.getMessage().equals("已经点赞过这篇文章了")) {
                    model.addAttribute("isLike", "isLike");
                    model.addAttribute("heart", "heart");
                }
            }
        }
        return "update";
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

    @Action("")
    @RequestMapping("/user/PersonalSystem/info")
    public String userSystem(Model model, HttpSession session, HttpServletRequest request) {
        return "user/userEdit";
    }


    @RequestMapping("/article/{articleId}")
    public String article(@PathVariable("articleId") Long articleId, HttpServletRequest request, Model model) {
        ArticleDTO articleDTO = null;
        if ((articleDTO = articleService.findArticleById(articleId)) != null) {
            model.addAttribute("article_info", articleDTO);
            Long userId = null;
            Cookie userCookie = null;
            if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
                if ((userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
                    ResultDTO resultDTO = article_userService.checkArticleIsLikeByUser(articleId, userId);
                    //如果用户点赞过这篇文章
                    if (resultDTO.getMessage().equals("已经点赞过这篇文章了")) {
                        model.addAttribute("isLike", "isLike");
                        model.addAttribute("heart", "heart");
                    }
                }
            }
        } else throw new NoFundException("404");
        return "article";
    }

    /**
     * @Method Description:
     * 跳转到用户主页  用户的主页是公开的，通过用户名就能访问到
     * @Author weleness
     * @Return
     */
    @RequestMapping({"/user/showUser/{userName}", "/user/userMain/{userName}"})
    public String showUser(@PathVariable("userName") String userName, Model model, HttpServletRequest request, @RequestParam(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        User user = userService.findUserByName(userName);
        if (user != null) {
            Cookie userCookie = null;
            UserDTO user1 = (UserDTO) model.getAttribute("user");
            model.addAttribute("siteNotice", siteNoticeService.findAll());
            model.addAttribute("pageHelper", articleService.findArticleByUserId(user.getUserId(), pageNo, pageSize));
            userService.findUserInfo(model, user);
            if (user1 != null) {
                if (!userName.equals(user1.getUserName())) {
                    model.addAttribute("isVisitor", "yes");
                }
            } else {
                model.addAttribute("isVisitor", "yes");
            }
        } else throw new NoFundException("404");
        return "user";
    }

    /**
     * @Method Description:
     * 用户个人中心的文章显示路由  个人主页是私有的，只能用户自己去访问
     * @Author weleness
     * @Return
     */
    @Action("articleList")
    @RequestMapping("/user/PersonalSystem/articleList")
    public String articleList(Model model, HttpSession session, HttpServletRequest request, @RequestParam(value = "pageNo", required = false) Integer pageNo, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        model.addAttribute("userArticlePageHelper", articleService.findArticleByUserId((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), pageNo, pageSize));
        return "user/articles";
    }

    /**
     * @Method Description:
     * 用户主页归档路由
     * @Author weleness
     * @Return
     */
    @Action("archives")
    @RequestMapping("/user/PersonalSystem/archives")
    public String article_archive(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("userArchiveList", archiveService.findArchives((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue())));
        return "user/article_archive";
    }

    @Action("modifyPassword")
    @RequestMapping("/user/PersonalSystem/modifyPassword")
    public String modifyPassword(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("userArchiveList", archiveService.findArchives((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue())));
        return "user/modifyPassword";
    }

    @Action("likeNotice")
    @RequestMapping("/user/MessageSystem/LikeNotification")
    public ModelAndView likeMessageSystem(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/notice/like");
        return mv;
    }

    @Action("comment_Reply")
    @RequestMapping("/user/MessageSystem/Comment_ReplyNotification")
    public ModelAndView commentMessageSystem(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/notice/commentReply");
        return mv;
    }

    @Action("systemNotice")
    @RequestMapping("/user/MessageSystem/systemNotification")
    public ModelAndView systemNoticeMessageSystem(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/notice/system");
        return mv;
    }

    @Action("editArticle")
    @RequestMapping("/article/markdown_edit")
    public String markdown_edit(Model model, @RequestParam("articleId") Long articleId, HttpSession session, HttpServletRequest request) {
        ArticleDTO article = articleService.findArticleById(articleId);
       Long userId =  (Long) request.getSession().getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue());
        if (article!=null && article.getUser().getUserId().equals(userId)) {
            model.addAttribute("authArticle", articleService.findArticleById(articleId));
            model.addAttribute("user_tag", tagService.findTagByUserId(userId));
            return "user/markdown_edit";
        } else throw new NoFundException("404");
    }

    @RequestMapping("/article_success")
    public String articleSubmitSuccess() {
        return "article_submit_success";
    }

    @RequestMapping("/search")
    public ModelAndView searchArticle(@RequestParam("key") String key, @RequestParam(value = "type", required = false) String type) {
        ModelAndView mv = new ModelAndView();
        if (type == null) type = "article";
        if (type.equals("article")) {
            List<ArticleDTO> article = articleService.searchArticle(key);
            mv.addObject("articles", article);
            mv.addObject("search", key);
            mv.addObject("type", "article");
        } else if (type.equals("tag")) {
            List<ArticleDTO> article = articleService.searchArticleByTag(tagService.searchTagByName(key));
            mv.addObject("articles", article);
            mv.addObject("search", key);
            mv.addObject("type", "tag");
        } else throw new NoFundException("404");
        mv.setViewName("result");
        return mv;
    }
}
