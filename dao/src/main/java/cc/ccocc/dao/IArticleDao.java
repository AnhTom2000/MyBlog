package cc.ccocc.dao;

import cc.ccocc.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created on 22:12  15/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository("articledao")
public interface IArticleDao {
    /**
     * @Method Description:
     * 查询所有标签
     * @Author weleness
     * @Return
     */

    @Results(id = "article_map", value = {
            @Result(id = true, column = "article_id", property = "a_id"), @Result(column = "article_name", property = "a_name"), @Result(column = "article_text", property = "a_text"),
            @Result(column = "create_time", property = "a_createTime",javaType = Date.class), // 指定为sql.Date类型，mybatis会自动截取日期，舍弃时间
            @Result(column = "View_statistics", property = "a_viewNums"),
            @Result(column = "Likes_statistics", property = "a_likeNums"),
            // 这里要记得制定以下javaType  不然查询回来的数据没有办法正确的接收到   column就是发过去的id  根据文章的id号查找标签
            @Result(property = "tag", javaType = List.class, column = "article_id", many = @Many(select = "cc.ccocc.dao.ITagDao.findByArticleId",fetchType = FetchType.LAZY))
    })
    @Select("SELECT article_id,article_name,article_text,create_time,View_statistics,Likes_statistics FROM tb_article")
    List<Article> findALL();

    /**
     * @Method
     * Description:
     *  统计所有的文章数
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_article")
    Integer article_Count();

    /**
     * @Method
     * Description:
     *  根据标签id查找对应的文章
     * @Author weleness
     *
     * @Return
     */
    @ResultMap(value = "article_map")
    @Select("SELECT article_id,article_name,article_text,create_time,View_statistics,Likes_statistics FROM tb_article a INNER JOIN tb_article_tag_category_middle m ON a.article_id = m.article_id WHERE m.tag_id = #{tag_id} ")
    List<Article> findArticleByTagId(@Param("tag_id")Integer tag_id);


    /**
     * @Method
     * Description:
     *  获得最新文章
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT article_id,article_name FROM tb_article WHERE date(create_time) BETWEEN '2019-12-01' AND '2029-12-31'")
    @ResultMap(value = "article_map")
    List<Article> findArticleNew();


    @Select("SELECT article_id,article_name,article_text,YEAR(create_time),MONTH(create_time),create_time,View_statistics,Likes_statistics FROM tb_article ORDER BY create_time")
    @Results(id = "article_archive", value = {
            @Result(id = true, column = "article_id", property = "a_id"), @Result(column = "article_name", property = "a_name"), @Result(column = "article_text", property = "a_text"),
            @Result(column = "View_statistics", property = "a_viewNums"),
            @Result(column = "Likes_statistics", property = "a_likeNums"),
            // 这里要记得制定以下javaType  不然查询回来的数据没有办法正确的接收到   column就是发过去的id  根据文章的id号查找标签
            @Result(property = "tag", javaType = List.class, column = "article_id", many = @Many(select = "cc.ccocc.dao.ITagDao.findByArticleId",fetchType = FetchType.LAZY)),
            @Result(column = "create_time", property = "a_createTime",javaType = Date.class),
            @Result(property = "a_year",column = "YEAR(create_time)",javaType = String.class),
            @Result(property = "a_month",column = "MONTH(create_time)",javaType = String.class)
    })
    List<Article> findArticleOrderByYear();



}
