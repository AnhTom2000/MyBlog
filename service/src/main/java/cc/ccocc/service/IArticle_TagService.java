package cc.ccocc.service;

import cc.ccocc.pojo.Article;

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
     * @param article  文章类，包含两个表所需要的所有信息
     */
    void saveInMiddle(Article article);
}
