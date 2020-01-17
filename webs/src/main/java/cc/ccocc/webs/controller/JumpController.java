package cc.ccocc.webs.controller;

import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArchiveService;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 22:04  17/01/2020
 * Description:
 *  跳转路由
 * @author Weleness
 */

@Controller
@SessionAttributes({"article_List","tag_List","article_new_List","article_count","tag_count"})
public class JumpController {
    @Autowired
    private IArchiveService archiveService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITagService tagService;

    /**
     * @Method
     * Description:
     *  主页路由
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("article_List", articleService.findAll());
        model.addAttribute("tag_List",tagService.findAll());
        model.addAttribute("article_new_List",articleService.findArticleNew());
        model.addAttribute("article_count",articleService.article_Count());
        model.addAttribute("tag_count",tagService.tag_Count());
        return "main";
    }

    /**
     * @Method
     * Description:
     *  归档路由
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/archives")
    public String archives(Model model,@SessionAttribute("article_List") List<Article> article_List){

        return "archives";
    }
    @RequestMapping("/test")
    public String test(@SessionAttribute("article_List") List<Article> article_List,Model model){
       model.addAttribute("article_List",article_List);
        return "test";
    }

    /**
     * @Method
     * Description:
     *  markdown编辑器路由
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/markdown")
    public String markdown(Model model) {

        return "markdown";
    }

    @RequestMapping("/rich")
    public String rich(Model model){

        return "rich";
    }


}
