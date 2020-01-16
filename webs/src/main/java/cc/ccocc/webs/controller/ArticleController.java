package cc.ccocc.webs.controller;

import cc.ccocc.service.IArticleService;
import cc.ccocc.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 14:25  16/01/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
public class ArticleController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITagService tagService;

    @RequestMapping("/")
    public String getArticle(Model model) {
        model.addAttribute("article_List", articleService.findAll());
        model.addAttribute("tag_List",tagService.findAll());
        model.addAttribute("article_new_List",articleService.findArticleNew());
        model.addAttribute("article_count",articleService.article_Count());
        model.addAttribute("tag_count",tagService.tag_Count());
        return "main";
    }
}
