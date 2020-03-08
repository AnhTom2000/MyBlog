package cc.ccocc.service;

import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.PageHelpDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Tag;

import java.util.List;

/**
 * Created on 22:14  15/01/2020
 * Description:
 *
 * @author Weleness
 */
public interface IArticleService {

    PageHelpDTO<List<Article>> findAll(Integer pageNo , Integer pageSize);

    Integer article_Count();

    Integer UserArticle_Count(Long userId);

    List<Article> findArticleByTagId(Long tag_id);

    List<Article> findAllArticleNew();

    List<Article> findArticleNewByUserId(Long userId);

    ResultDTO saveArticle(Article article, String[] tag, String category_id, String[] newTag,Long userId);

    ResultDTO updateArticle( Article article, String[] tag, String category_id, String[] newTag,Long userId);

    ArticleDTO findArticleById(Long articleId);

    ResultDTO addArticleLike(Long articleId, Long authId,Long userId,String article);

    ResultDTO addArticleViewStatistics(Long articleId);

    PageHelpDTO<List<ArticleDTO>> findArticleByUserId(Long userId,Integer pageNo,Integer pageSize);

    ResultDTO deleteArticle(Long articleId,Long userId);

    public List<ArticleDTO> searchArticle(String articleName);

    public List<ArticleDTO> searchArticleByTag(List<Tag> tags);
}
