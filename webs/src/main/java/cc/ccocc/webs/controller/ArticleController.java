package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.utils.date.DateUtils;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 14:25  16/01/2020
 * Description:
 *
 * @author Weleness
 */
@RestController
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping("/submit")
    public ResultDTO submit(Article article) {
        System.out.println(article);
        ResultDTO resultDTO = articleService.saveArticle(article);
        return resultDTO;
    }


}
