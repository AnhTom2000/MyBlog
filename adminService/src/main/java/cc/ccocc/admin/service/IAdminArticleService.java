package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Article;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 14:47  11/02/2020
 * Description:
 *
 * @author Weleness
 */

public interface IAdminArticleService {

    public AdminDTO<List<Article>> findAllArticle(Integer pageNo , Integer pageSize);

    public AdminDTO<List<Article>> findAllUnChecked(Integer pageNo , Integer pageSize);

    public AdminDTO deleteArticles(Long[] articleId);

    public Integer articleCount();

    public Integer uncheckedArticleCount();

    public AdminDTO checkArticle(Long articleId);

    public AdminDTO deleteByUser(Long userId);

    public AdminDTO<List<Article>> searchArticle(String userName, String articleTitle, String categoryName);

}
