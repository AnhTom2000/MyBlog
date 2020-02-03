package cc.ccocc.dao;

import cc.ccocc.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;
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
     * @param article_id 文章id
     */
    @Select("SELECT t.tag_id,t.tag_name,user_id FROM tb_tag t INNER JOIN tb_article_tag_middle m ON t.tag_id=m.tag_id WHERE m.article_id= #{article_id} ")
    @Results(id = "tag_map",value = {
            @Result(id = true,property = "tag_id",column ="tag_id",jdbcType = JdbcType.BIGINT,javaType = Long.class),
            @Result(property = "tag_name",column = "tag_name",jdbcType = JdbcType.VARCHAR , javaType = String.class),
            @Result(property = "user_id",column = "user_id",jdbcType = JdbcType.BIGINT,javaType = Long.class)
    })
    List<Tag> findByArticleId(@Param("article_id") Long article_id);

    /**
     * @Method Description:
     * 查询所有的标签总数
     * @Author weleness
     * @Return
     *
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
     *
     */
    @ResultMap("tag_map")
    @Select("SELECT tag_id,tag_name FROM tb_tag")
    List<Tag> findAll();

/**
 * @Method
 * Description:
 *  保存标签
 * @Author weleness
 *
 * @Return
 * @param tag_name  新增标签名
 */
    @Insert("INSERT INTO tb_tag(tag_id,tag_name,user_id) VALUE(#{tag_id},#{tag_name},#{userId})")
    void saveTag(@Param("tag_name") String tag_name,@Param("tag_id") Long tag_id,@Param("userId")Long userId);

    /**
     * @Method
     * Description:
     *  根据标签名查找标签
     * @Author weleness
     *
     * @Return
     * @param tagName 标签名称
     */
    @Select("SELECT tag_id,tag_name,user_id FROM tb_tag WHERE tag_name = #{tagName} AND user_id = #{userId} limit 0,1")
    @ResultMap("tag_map")
    Tag findByTagName(@Param("tagName") String tagName,@Param("userId") Long userId);


    @Select("SELECT tag_id,tag_name,user_id FROM tb_tag WHERE user_id = #{userId} ")
    List<Tag> findTagByUserId(@Param("userId") Long userId);
}
