package cc.ccocc.service;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Tag;

import java.util.List;

/**
 * Created on 22:40  18/01/2020
 * Description:
 *  文章标签中间表服务接口
 * @author Weleness
 */

public interface IArticle_TagService {

    /**
     * @Method
     * Description:
     *  中间表存储方法
     * @Author weleness
     *
     * @Return
     * @param article  文章类
     * @param tags  文章的标签
     */
    void saveInMiddle(Article article, List<Tag> tags);
}
