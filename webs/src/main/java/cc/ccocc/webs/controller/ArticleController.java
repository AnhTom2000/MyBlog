package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.utils.date.DateUtils;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.awt.*;
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

    @RequestMapping(value = "/submit",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultDTO submit(Article article,  @RequestParam("tag[]") String[] tag,@RequestParam("category_id")String category_id,@RequestParam("newTag[]") String[] newTag) {
        //转移html字符串
        article.setA_text(HtmlUtils.htmlEscapeHex(article.getA_text()));
        ResultDTO resultDTO = articleService.saveArticle(article,tag,category_id,newTag);
        return resultDTO;
    }


}
