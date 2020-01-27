package cc.ccocc.dao;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Category;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
     * 查询文章所有信息
     * @Author weleness
     * @Return
     */
    @Results(id = "article_map", value = {
            @Result(id = true, column = "article_id", property = "a_id", javaType = Long.class),
            @Result(column = "article_name", property = "a_Title"),
            @Result(column = "article_text", property = "a_text"),
            @Result(column = "markdown", property = "markdown", javaType = Boolean.class),
            @Result(column = "create_time", property = "a_createTime", javaType = LocalDateTime.class), // 指定为sql.Date类型，mybatis会自动截取日期，舍弃时间
            @Result(column = "u_id", property = "u_id", javaType = Long.class),
            @Result(column = "View_statistics", property = "a_viewNums"),
            @Result(column = "Likes_statistics", property = "a_likeNums"),
            @Result(column = "last_update", property = "a_last_update", javaType = LocalDateTime.class),
            @Result(property = "a_year", column = "YEAR(create_time)", javaType = String.class),
            @Result(property = "a_month", column = "MONTH(create_time)", javaType = String.class),
            // 这里要记得制定以下javaType  不然查询回来的数据没有办法正确的接收到   column就是发过去的id  根据文章的id号查找标签
            @Result(property = "tags", javaType = List.class, column = "article_id", many = @Many(select = "cc.ccocc.dao.ITagDao.findByArticleId", fetchType = FetchType.LAZY)),
            @Result(property = "category", column = "category_id", one = @One(select = "cc.ccocc.dao.ICategoryDao.findById", fetchType = FetchType.LAZY), javaType = Category.class)
    })
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,create_time," +
            "last_update,YEAR(create_time),MONTH(create_time),View_statistics," +
            "Likes_statistics,category_id FROM tb_article ORDER BY create_time DESC")
    List<Article> findALL();

    /**
     * @Method Description:
     * 统计所有的文章数
     * @Author weleness
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_article")
    Integer article_Count();

    /**
     * @Method Description:
     * 根据标签id查找对应的文章
     * @Author weleness
     * @Return
     */

    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,create_time, " +
            "last_update,YEAR(create_time),MONTH(create_time),View_statistics, " +
            "Likes_statistics  FROM tb_article a INNER JOIN tb_article_tag_middle m ON a.article_id = m.article_id WHERE m.tag_id = #{tag_id} ")
    List<Article> findArticleByTagId(@Param("tag_id") Long tag_id);


    /**
     * @Method Description:
     * 获得最新文章
     * @Author weleness
     * @Return
     */
    @Select("SELECT article_id,article_name,create_time FROM tb_article WHERE DATE(create_time) BETWEEN '2019-12-01' AND '2029-12-31' ORDER BY create_time DESC")
    @ResultMap(value = "article_map")
    List<Article> findArticleNew();


    /**
     * @Method Description:
     * 添加文章
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_article(article_id,article_name,u_id,article_text,markdown,create_time,last_update,category_id) VALUES (${article.a_id},'${article.a_Title}',${article.u_id},'${article.a_text}',${article.markdown},'${article.a_createTime}','${article.a_last_update}',${category.categoryid})")
    void saveArticle(@Param("article") Article article, @Param("category") Category category);


    /**
     * @param articleId  文章id
     * @Method
     * Description:
     *  根据id查找文章
     * @Author weleness
     *
     * @Return
     */
    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,create_time, " +
            "last_update,YEAR(create_time),MONTH(create_time),View_statistics, " +
            "Likes_statistics,category_id  FROM tb_article WHERE article_id = #{articleId}")
    Article findArticleById(@Param("articleId") Long articleId);


    /**
     * @param articleId 被点赞的文章id
     * @Method
     * Description:
     *  点赞+1
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_article SET Likes_statistics = Likes_statistics+1 WHERE article_id = #{articleId} ")
    Integer addArticleLike(@Param("articleId")Long articleId);

    /**
     * @param commentId 被点赞的评论id
     * @Method
     * Description:
     *  评论点赞+1
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_article_comment SET comment_like_count = comment_like_count+1 WHERE comment_id = #{commentId} ")
    Integer addArticleCommentLike(@Param("commentId") Long commentId);



}
