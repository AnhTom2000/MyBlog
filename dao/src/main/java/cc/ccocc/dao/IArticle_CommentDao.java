package cc.ccocc.dao;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Comment;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 11:26  26/01/2020
 * Description:
 * 文章评论dao
 *
 * @author Weleness
 */
@Repository
public interface IArticle_CommentDao {

    /**
     * @param articleId 文章的id
     * @Method Description:
     * 查询文章的所有评论
     * @Author weleness
     * @Return
     */
    @Results(id = "comment_map", value = {
            @Result(id = true, column = "comment_id", property = "commentId", javaType = Long.class),
            @Result(column = "comment_text", property = "commentContent"),
            @Result(column = "comment_like_count", property = "comment_like_count", javaType = Integer.class),
            @Result(column = "user_id", property = "user", javaType = User.class, one = @One(select = "cc.ccocc.dao.IUserDao.findUserById", fetchType = FetchType.LAZY)),
            @Result(column = "comment_time", property = "commentTime", javaType = LocalDateTime.class),
            @Result(column = "article_id", property = "article",javaType = Article.class,one = @One(select = "cc.ccocc.dao.IArticleDao.findArticleById",fetchType = FetchType.LAZY)),
            @Result(column = "comment_id", property = "replies", javaType = List.class, many = @Many(select = "cc.ccocc.dao.IArticle_Comment_ReplyDao.findReplyByCommentId", fetchType = FetchType.LAZY))
    })
    @Select("SELECT comment_id,comment_text,comment_like_count,user_id,comment_time,article_id FROM tb_article_comment WHERE article_id = #{articleId}")
    public List<Comment> findAllCommentByArticleId(@Param("articleId") Long articleId);

    /**
     * @param comment 评论信息
     * @Method Description:
     * 发表评论
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_article_comment(comment_id,comment_text,comment_like_count,user_id,comment_time,article_id) VALUES(#{comment.commentId},#{comment.commentContent},#{comment.comment_like_count},#{comment.user.userId},#{comment.commentTime},#{comment.article.a_id})")
    public Integer insertArticleComment(@Param("comment") Comment comment);

    /**
     * @param commentId  评论的id
     * @Method
     * Description:
     *  评论点赞
     * @Author weleness
     *
     * @Return
     */

    @Update("UPDATE tb_article_comment SET comment_like_count = comment_like_count+1 WHERE comment_id = #{commentId}")
    public Integer addCommentLike(@Param("commentId") Long commentId);

    @Select("SELECT COUNT(*) FROM tb_article_comment")
    public Integer getAllCommentCount();

   @ResultMap("comment_map")
    @Select("SELECT comment_id,comment_text,comment_like_count,user_id,comment_time,article_id FROM tb_article_comment ORDER BY comment_time DESC LIMIT 0,5 ")
    public List<Comment> getNewComment();
}
