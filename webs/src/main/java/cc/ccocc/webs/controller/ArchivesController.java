package cc.ccocc.webs.controller;

import cc.ccocc.service.IArticleService;
import cc.ccocc.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 17:41  16/01/2020
 * Description:
 *  归档跳转控制器
 * @author Weleness
 */
@RequestMapping("/")
@Controller
public class ArchivesController {
    @Autowired
    private ITagService tagService;
    @Autowired
    private IArticleService articleService;


    @RequestMapping("/archives")
    public String showArchives(Model model){
        model.addAttribute("article_List",articleService.findArticleOrderByYear());
        System.out.println(articleService.findArticleOrderByYear());
        return "archives";
    }
}
