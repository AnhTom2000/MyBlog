package cc.ccocc.service;

import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.CommentDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Article;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    List<Article> findArticleByTagId(Long tag_id);

    List<Article> findArticleNew();

    ResultDTO saveArticle(Article article, String[] tag, String category_id, String[] newTag);

    ArticleDTO findArticleById(Long articleId);

    ResultDTO addArticleLike(Long articleId, Long userId);


}
