package cc.ccocc.dao;

import cc.ccocc.pojo.Reply;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 13:30  26/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface IArticle_Comment_ReplyDao {

    /**
     * @Method
     * Description:
     *  查询这条评论的所有回复
     * @Author weleness
     *
     * @Return
     */
    @Results(id = "reply_map", value = {
            @Result(id =  true , column = "comment_reply_id", property = "replyId",javaType = Integer.class),
            @Result(column = "comment_reply_text",property = "replyContent"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select = "cc.ccocc.dao.IUserDao.findUserById",fetchType = FetchType.LAZY)),
            @Result(column = "article_comment_id",property = "commentId",javaType = Long.class),
            @Result(column = "comment_reply_time",property = "replyTime",javaType = LocalDateTime.class)
    })
    @Select("SELECT comment_reply_id,comment_reply_text,user_id,article_comment_id,comment_reply_time FROM tb_comment_reply WHERE article_comment_id = #{comment_id}")
    List<Reply> findReplyByCommentId(@Param("comment_id") Long commentId);

    /**
     * @Method
     * Description:
     *  发表评论回复
     * @Author weleness
     *
     * @Return
     */
    @Insert("INSERT INTO tb_comment_reply(comment_reply_text,user_id,article_comment_id,comment_reply_time) VALUES(#{reply.replyContent},#{reply.user.userId},#{reply.commentId},#{reply.replyTime})")
    Integer insertCommentReply(@Param("reply") Reply reply);
}
