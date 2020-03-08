package cc.ccocc.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created on 22:36  18/01/2020
 * Description:
 * 文章标签中间表dao
 *
 * @author Weleness
 */
@Repository("IArticle_TagDao")
public interface IArticle_TagDao {

    /**
     * @param articleId 文章id
     * @param tagId     标签id
     * @Method Description:
     * 文章标签中间表保存方法
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_article_tag_middle(article_id,tag_id) VALUES(#{articleId},#{tagId})")
    Integer saveInMiddle(@Param("articleId") Long articleId, @Param("tagId") Long tagId);

    /**
     * @param articleId 文章id
     * @Method
     * Description:
     *  文章标签中间表删除方法
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_article_tag_middle WHERE article_id = #{articleId}")
    void  deleteInMiddle(@Param("articleId")Long articleId);

}
