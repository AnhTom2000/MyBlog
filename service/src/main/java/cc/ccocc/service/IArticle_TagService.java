package cc.ccocc.service;

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

public interface IArticle_TagService {

    /**
     * @param article 文章类
     * @param tags    文章的标签
     * @Method Description:
     * 中间表添加信息
     * @Author weleness
     * @Return
     */
    Integer saveInMiddle(Article article, List<Tag> tags);

    /**
     * @param article 文章信息
     * @param tags    标签信息
     * @Method Description:
     * 中间表修改信息
     * @Author weleness
     * @Return
     */
    Integer updateInMiddle(Article article, List<Tag> tags);

    void  deleteInMiddle(Article article);
}
