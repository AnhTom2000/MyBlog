package cc.ccocc.dao;
import cc.ccocc.pojo.LikeNotification;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 21:09  07/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface IArticle_LikeNotificationDao {

    /**
     * @param likeNotification 点赞消息信息
     * @Method Description:
     * 增加文章点赞消息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_likeNotification(likeNotification_id,user_id,auth_id,article_id,article_title,type,create_time,markread) VALUES (#{notice.likeNotificationId},#{notice.userId},#{notice.authId},#{notice.articleId},#{notice.articleTitle},#{notice.type},#{notice.createTime},#{notice.markRead})")
    Integer addArticle_LikeNotification(@Param("notice") LikeNotification likeNotification);

    /**
     *
     * @param likeNotification  点赞消息信息
     * @Method
     * Description:
     *  增加评论点赞消息
     * @Author weleness
     *
     * @Return
     */
    @Insert("INSERT INTO tb_likeNotification(likeNotification_id,user_id,auth_id,article_id,article_title,comment_content,type,create_time,markread) VALUES (#{notice.likeNotificationId},#{notice.userId},#{notice.authId},#{notice.articleId},#{notice.articleTitle},#{notice.commentContent},#{notice.type},#{notice.createTime},#{notice.markRead})")
    Integer addComment_LikeNotification(@Param("notice") LikeNotification likeNotification);

    /**
     * @Method Description:
     * 标记为已读
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_likeNotification SET markread = true WHERE auth_id = #{authId}")
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
    @Delete("DELETE FROM tb_likeNotification WHERE auth_id = #{authId}")
    Integer deleteLikeNotice(@Param("authId") Long authId);

    /**
     * @param likeNotificationId 消息推送id
     * @Method
     * Description:
     *  删除单个消息推送
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_likeNotification WHERE likeNotification_id = #{likeNoticeId}")
    Integer deleteLikeNoticeOne(@Param("likeNoticeId") Long likeNotificationId);
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
            @Result(id = true,column = "likeNotification_id",property = "likeNotificationId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select = "cc.ccocc.dao.IUserDao.findUserById",fetchType = FetchType.LAZY)),
            @Result(column = "auth_id",property = "authId"),
            @Result(column = "article_id",property = "articleId"),
            @Result(column = "article_title",property = "articleTitle"),
            @Result(column = "comment_content",property = "commentContent"),
            @Result(column = "type",property = "type"),
            @Result(column = "create_time",property = "createTime",javaType = LocalDateTime.class),
            @Result(column = "markread",property = "markRead",javaType = Boolean.class)
    })
    @Select("SELECT likeNotification_id,user_id,auth_id,article_id,article_title,comment_content,type," +
            "create_time,markread FROM tb_likeNotification WHERE auth_id = #{authId} ")
    List<LikeNotification> findNoticeByUserId(@Param("authId") Long authId);

    /**
     * @Method
     * Description:
     *  统计未读消息数量
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_likeNotification WHERE auth_id = #{authId} AND markread = false")
    Integer UnMarkReadCount(@Param("authId") Long authId);
}
