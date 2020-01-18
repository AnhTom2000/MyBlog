package cc.ccocc.webs.controller;


import cc.ccocc.service.IArchiveService;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;


/**
 * Created on 22:04  17/01/2020
 * Description:
 *  跳转路由
 * @author Weleness
 */

@Controller
public class JumpController {

    @Autowired
    private IArchiveService archiveService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITagService tagService;



    // 这个方法会在其他请求控制器方法调用之前被调用，来完成主要的数据存入
    @ModelAttribute
    public void beforePage(Model model , HttpServletRequest request){
        model.addAttribute("article_List", articleService.findAll());
        model.addAttribute("tag_List",tagService.findAll());
        model.addAttribute("article_new_List",articleService.findArticleNew());
        model.addAttribute("article_count",articleService.article_Count());
        model.addAttribute("tag_count",tagService.tag_Count());
        model.addAttribute("archive_List",archiveService.findArchives());
    }
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
    public String archives(Model model){
        return "archives";
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

    /**
     * @Method
     * Description:
     *  富文本编辑器路由
     * @Author weleness
     *
     * @Return
     */
    @RequestMapping("/rich")
    public String rich(Model model){
        return "rich";
    }


}