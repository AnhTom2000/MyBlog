package cc.ccocc.dao;

import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 05:22  25/01/2020
 * Description:
 *  用户，文章中间表dao
 * @author Weleness
 */
@Repository
public interface IArticle_UserDao {

    /**
     * @param
     * @Method
     * Description:
     *  通过中间表查用户是否已经点赞过这篇文章
     * @Author weleness
     *
     * @Return
     */
    @Results(id = "user_map", value = {
            @Result(id = true, column = "user_id", property = "userId", javaType = Long.class),
            @Result(column = "username", property = "userName",javaType = String.class),
            @Result(column = "password", property = "password"),
            @Result(column = "avatar_url", property = "avatarUrl"),
            @Result(column = "email", property = "email"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "gender", property = "gender", javaType = Boolean.class),
            @Result(column = "age", property = "age", javaType = Short.class),
            @Result(column = "area", property = "area"),
            @Result(column = "profession", property = "profession"),
            @Result(column = "description", property = "description"),
            @Result(column = "login_count", property = "loginCount"),
            @Result(column = "last_login", property = "lastLogin", javaType = LocalDateTime.class),
            @Result(column = "create_time", property = "createTime", javaType = LocalDateTime.class),
            @Result(column = "locked", property = "locked", javaType = Boolean.class),
            @Result(column = "message_count", property = "messageCount")
    })
    @Select("SELECT  m.article_id,m.user_id FROM tb_user_article_like_middle m WHERE m.user_id = #{userId} AND m.article_id = #{articleId}")
    Long findArticleIsLikeByOneUser(@Param("userId") Long userId,@Param("articleId") Long articleId );

    @Insert("INSERT INTO tb_user_article_like_middle(user_id,article_id) VALUES(#{userId},#{articleId})")
    Integer addSourceInMiddle(@Param("userId") Long userId, @Param("articleId") Long articleId);

    @Delete("DELETE FROM tb_user_article_like_middle WHERE user_id = #{userId}")
    Integer deleteByUser(@Param("userId") Long userId);

}
