package cc.ccocc.dao;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Category;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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


    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,create_time," +
            "category_id,checked FROM tb_article WHERE checked=false ORDER BY View_statistics DESC LIMIT #{pageNo},#{pageSize}")
    public List<Article> findAllUnchecked(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,archive_id,create_time," +
            "last_update,View_statistics," +
            "Likes_statistics,category_id,checked FROM tb_article WHERE u_id LIKE '${userId}' OR article_name LIKE '${articleTitle}' OR category_id LIKE '${categoryName}'")
    public List<Article> searchArticle(@Param("userId") String userId, @Param("articleTitle") String articleTitle, @Param("categoryName") String categoryName);

    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,archive_id,create_time," +
            "View_statistics," +
            "Likes_statistics,category_id,checked FROM tb_article WHERE checked = true AND article_name LIKE '${articleName}'")
    public List<Article> searchArticleByName(@Param("articleName") String articleName);

    /**
     * @Method Description:
     * 查询文章所有信息,根据观看人数也就是热度排序
     * @Author weleness
     * @Return
     */
    @Results(id = "article_map", value = {
            @Result(id = true, column = "article_id", property = "a_id", javaType = Long.class),
            @Result(column = "article_name", property = "a_Title"),
            @Result(column = "article_text", property = "a_text"),
            @Result(column = "markdown", property = "markdown", javaType = Boolean.class),
            @Result(column = "create_time", property = "a_createTime", javaType = LocalDateTime.class), // 指定为sql.Date类型，mybatis会自动截取日期，舍弃时间
            @Result(column = "u_id", property = "user", javaType = User.class, one = @One(select = "cc.ccocc.dao.IUserDao.findUserById", fetchType = FetchType.LAZY)),
            @Result(column = "archive_id", property = "archiveId", javaType = Long.class),
            @Result(column = "View_statistics", property = "a_viewNums"),
            @Result(column = "Likes_statistics", property = "a_likeNums"),
            @Result(column = "last_update", property = "a_last_update", javaType = LocalDateTime.class),
            // 这里要记得制定以下javaType  不然查询回来的数据没有办法正确的接收到   column就是发过去的id  根据文章的id号查找标签
            @Result(property = "tags", javaType = List.class, column = "article_id", many = @Many(select = "cc.ccocc.dao.ITagDao.findByArticleId", fetchType = FetchType.LAZY)),
            @Result(property = "category", column = "category_id", one = @One(select = "cc.ccocc.dao.ICategoryDao.findById", fetchType = FetchType.LAZY), javaType = Category.class),
            @Result(column = "checked", property = "checked", javaType = Boolean.class)
    })
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,archive_id,create_time," +
            "last_update,View_statistics," +
            "Likes_statistics,category_id,checked FROM tb_article WHERE checked = true ORDER BY View_statistics DESC LIMIT #{pageNo},#{pageSize} ")
    List<Article> findALL(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);


    /**
     * @Method Description:
     * 统计所有的文章数
     * @Author weleness
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_article")
    Integer article_Count();

    @Select("SELECT COUNT(*) FROM tb_article WHERE u_id = #{userId} AND checked =  true")
    Integer UserArticle_Count(@Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM tb_article WHERE u_id = #{userId}")
    Integer article_CountByUserId(@Param("userId") Long userId);

    @Select("SELECT COUNT(*) FROM tb_article WHERE checked = false")
    Integer uncheckedArticle_count();

    /**
     * @Method Description:
     * 根据标签id查找对应的文章
     * @Author weleness
     * @Return
     */
    @ResultMap("article_map")
    @Select("SELECT a.article_id,a.u_id,a.article_name,a.article_text,a.markdown,a.archive_id,a.create_time," + "a.last_update,a.View_statistics," + "a.Likes_statistics,a.category_id,a.checked FROM tb_article a INNER JOIN tb_article_tag_middle m ON a.article_id = m.article_id WHERE m.tag_id = #{tag_id} AND a.checked = true")
    List<Article> findArticleByTagId(@Param("tag_id") Long tag_id);


    /**
     * @Method Description:
     * 获得最新文章
     * @Author weleness
     * @Return
     */
    @Select("SELECT article_id,u_id,article_name,create_time FROM tb_article WHERE  DATE(create_time) BETWEEN '2019-12-01' AND '2029-12-31' AND checked = true ORDER BY create_time DESC LIMIT 0,5 ")
    @ResultMap(value = "article_map")
    List<Article> findArticleNew();

    /**
     * @param userId 用户主键
     * @Method Description:
     * 获得用户的最新文章
     * @Author weleness
     * @Return
     */
    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,create_time FROM tb_article WHERE u_id = #{userId} AND DATE(create_time) BETWEEN '2019-12-01' AND '2029-12-31' AND checked=true ORDER BY create_time DESC LIMIT 0,5  ")
    List<Article> findArticleNewByUserId(@Param("userId") Long userId);


    /**
     * @Method Description:
     * 添加文章
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_article(article_id,article_name,u_id,article_text,markdown,archive_id,create_time,last_update,category_id,checked) VALUES (${article.a_id},'${article.a_Title}',${article.user.userId},'${article.a_text}',${article.markdown},#{article.archiveId},'${article.a_createTime}','${article.a_last_update}',${category.categoryid},#{article.checked})")
    Integer saveArticle(@Param("article") Article article, @Param("category") Category category);

    /**
     * @param article  文章信息
     * @param category 分类信息
     * @Method Description:
     * 修改文章
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_article SET article_name = #{article.a_Title},article_text='${article.a_text}',last_update='${article.a_last_update}',category_id = #{category.categoryid} WHERE article_id = #{article.a_id}")
    Integer updateArticle(@Param("article") Article article, @Param("category") Category category);


    /**
     * @param articleId 文章id
     * @Method Description:
     * 根据id查找文章
     * @Author weleness
     * @Return
     */
    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,archive_id,create_time, " +
            "last_update,View_statistics, " +
            "Likes_statistics,category_id,checked  FROM tb_article WHERE article_id = #{articleId}")
    Article findArticleById(@Param("articleId") Long articleId);

    @Select("SELECT article_id,u_id,article_name,article_text,markdown,archive_id,create_time, " +
            "last_update,View_statistics," +
            "Likes_statistics,category_id,checked  FROM tb_article WHERE article_id = #{articleId} AND locked = true")
    Article findArticleByCommentId();

    /**
     * @param articleId 被点赞的文章id
     * @Method Description:
     * 点赞+1
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_article SET Likes_statistics = Likes_statistics+1 WHERE article_id = #{articleId} ")
    Integer addArticleLike(@Param("articleId") Long articleId);

    /**
     * @param commentId 被点赞的评论id
     * @Method Description:
     * 评论点赞+1
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_article_comment SET comment_like_count = comment_like_count+1 WHERE comment_id = #{commentId} ")
    Integer addArticleCommentLike(@Param("commentId") Long commentId);


    /**
     * @Method Description:
     * 文章观看人次
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_article SET View_statistics = View_statistics+1 WHERE article_id = #{articleId}")
    Integer addArticleViewStatistics(@Param("articleId") Long articleId);


    /**
     * @param userId 用户主键
     * @Method Description:
     * 查找用户的文章
     * @Author weleness
     * @Return
     */
    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,archive_id,create_time, " +
            "last_update,View_statistics, " +
            "Likes_statistics,category_id,checked FROM tb_article WHERE u_id = #{userId} AND checked = true  ORDER BY create_time DESC LIMIT #{pageNo},#{pageSize} ")
    List<Article> findArticleByUserId(@Param("userId") Long userId,@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);


    /**
     * @param articleId 文章id
     * @Method Description:
     * 删除指定文章
     * 保证在左表有数据的情况下删除
     * @Author weleness
     * @Return
     */
    @Delete("DELETE tb_article,tb_article_comment,tb_comment_reply,tb_user_comment_like_middle FROM\n" +
            " tb_article LEFT  JOIN tb_article_comment ON tb_article.article_id =\n" +
            " tb_article_comment.article_id  LEFT JOIN tb_comment_reply ON \n" +
            "tb_comment_reply.comment_reply_time = tb_article_comment.comment_id LEFT JOIN\n" +
            " tb_user_comment_like_middle ON tb_article_comment.comment_id = \n" +
            "tb_user_comment_like_middle.article_comment_id WHERE tb_article.article_id = #{articleId}")
    Integer deleteArticleById(@Param("articleId") Long articleId);

    @Delete("DELETE FROM tb_article WHERE u_id = #{userId}")
    Integer deleteArticleByUserId(@Param("userId") Long userId);

    @Update("UPDATE tb_article SET checked = !checked WHERE article_id = #{articleId}")
    Integer checkArticle(@Param("articleId") Long articleId);

    @ResultMap("article_map")
    @Select("SELECT article_id,u_id,article_name,article_text,markdown,archive_id,create_time, last_update,View_statistics, Likes_statistics,category_id,checked FROM tb_article WHERE archive_id = #{archive_id} AND checked = true  ORDER BY create_time DESC ")
    public List<Article> findArticleByArchiveId(@Param("archive_id") Long archive_id);



}
