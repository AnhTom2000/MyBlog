package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created on 22:14  15/01/2020
 * Description:
 *
 * @author Weleness
 */
public interface IArticleService {

    List<Article> findAll();

    Integer article_Count();

    List<Article> findArticleByTagId(Integer tag_id);

    List<Article> findArticleNew();

    ResultDTO saveArticle(Article article);

}
