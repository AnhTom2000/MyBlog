package cc.ccocc.admin.service;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Tag;

import java.util.List;

/**
 * Created on 22:40  18/01/2020
 * Description:
 * 文章标签中间表服务接口
 *
 * @author Weleness
 */

public interface IAdminArticle_TagService {

    void  deleteInMiddle(Article article);
    void  deleteInMiddleByUser(Long articleId);
}
