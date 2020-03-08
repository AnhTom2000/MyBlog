package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 19:39  08/02/2020
 * Description:
 *
 * @author Weleness
 */
@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class CommentNotification implements Serializable {

    private static final long serialVersionUID = 16351651L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long article_comment_Notification_id;
    // 评论的用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    // 评论的用户
    private User user;
    // 被评论的用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long authId;
    // 评论的主键
    @JsonSerialize(using = ToStringSerializer.class)
    private Long commentId;
    // 评论和回复所属的文章id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;
    // 回复的主键
    private Integer replyId;
    // 消息类型
    private String type;
    // 消息内容
    private String commentContent;
    // 消息创建时间
    private LocalDateTime createTime;
    // 是否已读
    private Boolean markRead;
    // 未读消息数量
    private Integer UnMarkStatics;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentNotification)) return false;
        CommentNotification that = (CommentNotification) o;
        return Objects.equals(article_comment_Notification_id, that.article_comment_Notification_id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(authId, that.authId) &&
                Objects.equals(commentId, that.commentId) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(replyId, that.replyId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(commentContent, that.commentContent) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(markRead, that.markRead) &&
                Objects.equals(UnMarkStatics, that.UnMarkStatics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comment_Notification_id, userId, user, authId, commentId, articleId, replyId, type, commentContent, createTime, markRead, UnMarkStatics);
    }
}
