package cc.ccocc.dao;

import cc.ccocc.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 19:37  08/02/2020
 * Description:
 *  评论回复消息推送dao
 * @author Weleness
 */
@Repository
public interface IArticle_Comment_NotificationDao {

    /**
     * @param commentNotification 评论回复消息信息
     * @Method Description:
     * 增加评论回复消息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_article_comment_Notification(article_comment_Notification_id,user_id,auth_id,article_id,reply_id,type,comment_content,create_time,markread) VALUES (#{notice.article_comment_Notification_id},#{notice.userId},#{notice.authId},#{notice.articleId},#{notice.replyId},#{notice.type},#{notice.commentContent},#{notice.createTime},#{notice.markRead})")
    Integer addComment_replyNotification(@Param("notice") CommentNotification commentNotification);

    /**
     *
     * @param commentNotification  评论消息信息
     * @Method
     * Description:
     *  增加评论消息
     * @Author weleness
     *
     * @Return
     */
    @Insert("INSERT INTO tb_article_comment_Notification(article_comment_Notification_id,user_id,auth_id,article_id,comment_id,type,comment_content,create_time,markread) VALUES (#{notice.article_comment_Notification_id},#{notice.userId},#{notice.authId},#{notice.articleId},#{notice.commentId},#{notice.type},#{notice.commentContent},#{notice.createTime},#{notice.markRead})")
    Integer addArticle_CommentNotification(@Param("notice") CommentNotification commentNotification);

    /**
     * @Method Description:
     * 标记为已读
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_article_comment_Notification SET markread = true WHERE auth_id = #{authId}")
    Integer updateMarkReadStatus(@Param("authId") Long authId);

    /**
     * @param authId 被点赞的用户id
     * @Method
     * Description:
     *  删除消息
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_article_comment_Notification WHERE auth_id = #{authId}")
    Integer deleteAllCommemtNotice(@Param("authId") Long authId);

    /**
     * @param commentNotificationId 消息推送id
     * @Method
     * Description:
     *  删除单个消息推送
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_article_comment_Notification WHERE article_comment_Notification_id = #{commentNoticeId}")
    Integer deleteCommentNoticeOne(@Param("commentNoticeId") Long commentNotificationId);

    @Delete("DELETE FROM tb_article_comment_Notification WHERE auth_id = #{authId}")
    void delteCommentNoticeByUser(@Param("authId")Long authId);

    /**
     * @param authId 用户的id
     * @Method
     * Description:
     *  查找用户相应的点赞消息推送
     * @Author weleness
     *
     * @Return
     */
    @Results(id = "notice_map",value = {
            @Result(id = true,column = "article_comment_Notification_id",property = "article_comment_Notification_id"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select = "cc.ccocc.dao.IUserDao.findUserById",fetchType = FetchType.LAZY)),
            @Result(column = "auth_id",property = "authId"),
            @Result(column = "comment_id",property = "commentId"),
            @Result(column = "article_id",property = "articleId"),
            @Result(column = "reply_id",property = "replyId"),
            @Result(column = "comment_content",property = "commentContent"),
            @Result(column = "type",property = "type"),
            @Result(column = "auth_id",property = "UnMarkStatics",one = @One(select = "cc.ccocc.dao.IArticle_Comment_NotificationDao.UnMarkReadCount",fetchType = FetchType.LAZY)),
            @Result(column = "create_time",property = "createTime",javaType = LocalDateTime.class),
            @Result(column = "markread",property = "markRead",javaType = Boolean.class)
    })
    @Select("SELECT article_comment_Notification_id,user_id,auth_id,article_id,comment_id,reply_id,type," +
            "comment_content,create_time,markread FROM tb_article_comment_Notification WHERE auth_id = #{authId} ")
    List<CommentNotification> findNoticeByUserId(@Param("authId") Long authId);

    /**
     * @Method
     * Description:
     *  统计未读消息数量
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_article_comment_Notification WHERE auth_id = #{authId} AND markread = false")
    Integer UnMarkReadCount(@Param("authId") Long authId);
}
