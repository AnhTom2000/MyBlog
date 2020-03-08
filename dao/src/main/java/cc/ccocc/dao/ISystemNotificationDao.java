package cc.ccocc.dao;

import cc.ccocc.pojo.CommentNotification;
import cc.ccocc.pojo.SystemNotification;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 21:37  09/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface ISystemNotificationDao {

    @Delete("DELETE FROM tb_systemNotification Where user_id = #{userId}")
    public void  deleteByUser(@Param("userId") Long userId);

    /**
     * @param systemNotification 系统通知消息
     * @Method Description:
     * 增加评论回复消息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_systemNotification(systemNotification_id,user_id,source_id,message_title,type,message_content,create_time,markread) VALUES (#{notice.systemNotificationId},#{notice.userId},#{notice.sourceId},#{notice.messageTitle},#{notice.type},#{notice.messageContent},#{notice.createTime},#{notice.markRead})")
    Integer addSystemNotificationToUser(@Param("notice") SystemNotification systemNotification);

    /**
     * @param systemNotification 系统通知消息
     * @Method Description:
     * 增加评论回复消息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_systemNotification(systemNotification_id,user_id,message_title,type,message_content,create_time,markread) VALUES (#{notice.systemNotificationId},#{notice.userId},#{notice.messageTitle},#{notice.type},#{notice.messageContent},#{notice.createTime},#{notice.markRead})")
    Integer addBadSystemNotificationToUser(@Param("notice") SystemNotification systemNotification);

    /**
     * @Method Description:
     * <p>标记为已读</p>
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_systemNotification SET markread = true WHERE user_id = #{userId}")
    Integer updateMarkReadStatus(@Param("userId") Long userId);

    /**
     * @param userId 被点赞的用户id
     * @Method
     * Description:
     *  <p>删除消息</p>
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_systemNotification WHERE user_id = #{userId}")
    Integer deleteAllCommemtNotice(@Param("userId") Long userId);

    /**
     * @param systemNotificationId 消息推送id
     * @Method
     * Description:
     *  <p>删除单个消息推送</p>
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_systemNotification WHERE systemNotification_id = #{systemNotificationId}")
    Integer deleteCommentNoticeOne(@Param("systemNotificationId") Long systemNotificationId);


    /**
     * @param userId 用户的id
     * @Method
     * Description:
     *  <p>查找用户相应的点赞消息推送</p>
     * @Author weleness
     *
     * @Return
     */
    @Results(id = "notice_map",value = {
            @Result(id = true,column = "systemNotification_id",property = "systemNotificationId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select = "cc.ccocc.dao.IUserDao.findUserById",fetchType = FetchType.LAZY)),
            @Result(column = "message_title",property = "messageTitle"),
            @Result(column = "source_id",property = "sourceId"),
            @Result(column = "message_content",property = "messageContent"),
            @Result(column = "type",property = "type"),
            @Result(column = "user_id",property = "unMarkStatics",one = @One(select = "cc.ccocc.dao.ISystemNotificationDao.UnMarkReadCount",fetchType = FetchType.LAZY)),
            @Result(column = "create_time",property = "createTime",javaType = LocalDateTime.class),
            @Result(column = "markread",property = "markRead",javaType = Boolean.class)
    })
    @Select("SELECT systemNotification_id,user_id,source_id,message_title,message_content,type," +
            "create_time,markread FROM tb_systemNotification WHERE user_id = #{userId} ")
    List<SystemNotification> findNoticeByUserId(@Param("userId") Long userId);

    /**
     * @param userId 用户id
     * @Method
     * Description:
     *  <p>统计未读消息数量</p>
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_systemNotification WHERE user_id = #{userId} AND markread = false")
    Integer UnMarkReadCount(@Param("userId") Long userId);
}
