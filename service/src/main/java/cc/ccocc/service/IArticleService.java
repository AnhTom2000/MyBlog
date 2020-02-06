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

    List<Article> findAllArticleNew();

    List<Article> findArticleNewByUserId(Long userId);

    ResultDTO saveArticle(Article article, String[] tag, String category_id, String[] newTag,Long userId);

    ResultDTO updateArticle( Article article, String[] tag, String category_id, String[] newTag,Long userId);

    ArticleDTO findArticleById(Long articleId);

    ResultDTO addArticleLike(Long articleId, Long userId);

    ResultDTO addArticleViewStatistics(Long articleId);

    List<ArticleDTO> findArticleByUserId(Long userId);

    ResultDTO deleteArticle(Long articleId);

}
