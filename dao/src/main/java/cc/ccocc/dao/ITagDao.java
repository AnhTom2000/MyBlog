package cc.ccocc.dao;

import cc.ccocc.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 23:09  15/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository("tagdao")
public interface ITagDao {

    /**
     * @Method Description:
     * 根据文章id查询对应的标签
     * @Author weleness
     * @Return
     */
    @Select("SELECT t.tag_id,t.tag_name FROM tb_tag t INNER JOIN tb_article_tag_category_middle m ON t.tag_id=m.tag_id WHERE m.article_id= #{article_id} ")
    List<Tag> findByArticleId(@Param("article_id") Integer article_id);

    /**
     * @Method Description:
     * 查询所有的标签总数
     * @Author weleness
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_tag")
    Integer tag_Count();

    /**
     * @Method
     * Description:
     *  查询所有标签
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT tag_id,tag_name FROM tb_tag")
    List<Tag> findAll();
}
