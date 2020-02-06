package cc.ccocc.webs.controller;


import cc.ccocc.dto.*;
import cc.ccocc.pojo.User;
import cc.ccocc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static cc.ccocc.service.impl.AbstractOauthService.*;


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

    // 这个方法会在其他请求控制器方法调用之前被调用，来完成主要的数据存入
    @ModelAttribute
    public void beforePage(Model model, HttpServletRequest request) {
        Cookie userCookie = null;
        UserDTO userDTO = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                userDTO = userService.findUserById(userId);
            }
        }
        if (userDTO != null) {
            model.addAttribute("user", userDTO);
        }

        model.addAttribute("article_new_List", articleService.findAllArticleNew());
        model.addAttribute("allCounts", allCountService.getAllCount());
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
        UserDTO user = (UserDTO) model.getAttribute("user");
        System.out.println(user);
        if(user != null){
            model.addAttribute("user_tag", tagService.findTagByUserId(user.getUserId()));
        }else return "login";
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

    @RequestMapping("/user/PersonalSystem/info")
    public String userSystem() {
        return "admin/userEdit";
    }


    @RequestMapping("/article/{articleId}")
    public String article(@PathVariable("articleId") String articleId, Model model, HttpServletRequest request) {
        UserDTO userDTO = null;
        model.addAttribute("article_info", articleService.findArticleById(Long.parseLong(articleId)));
        if ((userDTO = (UserDTO) model.getAttribute("user")) != null) {
            ResultDTO resultDTO = article_userService.checkArticleIsLikeByUser(Long.parseLong(articleId), userDTO.getUserId());
            //如果用户点赞过这篇文章
            if (resultDTO.isStatus()) {
                model.addAttribute("isLike", "isLike");
                model.addAttribute("heart", "heart");
            }
        }

        return "article";
    }

    /**
     * @Method Description:
     * 跳转到用户主页  用户的主页是公开的，通过用户名就能访问到
     * @Author weleness
     * @Return
     */
    @RequestMapping({"/user/showUser/{userName}", "/user/userMain/{userName}"})
    public String showUser(@PathVariable("userName") String userName, Model model, HttpServletRequest request) {
        User user = userService.findUserByName(userName);
        if (user != null) {
            UserDTO user1 = (UserDTO) model.getAttribute("user");
            userService.findUserInfo(model, user);
            if (user1 != null) {
                if (!userName.equals(user1.getUserName())) {
                    model.addAttribute("isVisitor", "yes");
                }
            } else {
                model.addAttribute("isVisitor", "yes");
            }

        } else return "404";
        return "user";
    }

    /**
     * @Method
     * Description:
     *  用户个人中心的文章显示路由  个人主页是私有的，只能用户自己去访问
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/user/PersonalSystem/articleList")
    public String articleList(Model model) {
        UserDTO userDTO = null;
        if((userDTO = (UserDTO) model.getAttribute("user"))!=null){
            model.addAttribute("userArticleList",articleService.findArticleByUserId(userDTO.getUserId()));
        }else return  "redirect: /login";
        return "admin/articles";
    }

    /**
     * @Method
     * Description:
     *  用户主页归档路由
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/user/PersonalSystem/archives")
    public String article_archive(Model model){
        UserDTO userDTO = null;
        if((userDTO = (UserDTO) model.getAttribute("user"))!=null){
            model.addAttribute("userArchiveList",archiveService.findArchives(userDTO.getUserId()));
        }else return  "redirect: /login";
        return "admin/article_archive";
    }

    @RequestMapping("/user/PersonalSystem/modifyPassword")
    public String modifyPassword(Model model){
        UserDTO userDTO = null;
        if((userDTO = (UserDTO) model.getAttribute("user"))!=null){
            model.addAttribute("userArchiveList",archiveService.findArchives(userDTO.getUserId()));
        }else return  "redirect: /login";
        return "admin/modifyPassword";
    }


    @RequestMapping("/article/markdown_edit")
    public String markdown_edit(Model model, @RequestParam("articleId")Long articleId , @RequestParam("authId")Long authId){
        UserDTO userDTO = null;
        if((userDTO = (UserDTO) model.getAttribute("user"))!=null){
            if(authId.equals(userDTO.getUserId())){
                model.addAttribute("authArticle",articleService.findArticleById(articleId));
                model.addAttribute("user_tag", tagService.findTagByUserId(authId));
            }else return "404";
        }else return  "redirect: /login";

        return "admin/markdown_edit";
    }





}
