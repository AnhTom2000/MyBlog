package cc.ccocc.dto;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Comment;
import cc.ccocc.pojo.Reply;
import cc.ccocc.pojo.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 19:51  08/02/2020
 * Description:
 *
 * @author Weleness
 */

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class CommentNotificationDTO implements Serializable {

    private static final long serialVersionUID = 5165165L;

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
    // 评论或回复内容
    private String commentContent;
    // 消息类型
    String type;
    // 消息创建时间
    private LocalDateTime createTime;
    // 是否已读
    private Boolean markRead;

    private Integer UnMarkStatics;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentNotificationDTO)) return false;
        CommentNotificationDTO that = (CommentNotificationDTO) o;
        return Objects.equals(article_comment_Notification_id, that.article_comment_Notification_id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(authId, that.authId) &&
                Objects.equals(commentId, that.commentId) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(replyId, that.replyId) &&
                Objects.equals(commentContent, that.commentContent) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(markRead, that.markRead) &&
                Objects.equals(UnMarkStatics, that.UnMarkStatics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_comment_Notification_id, userId, user, authId, commentId, articleId, replyId, commentContent, type, createTime, markRead, UnMarkStatics);
    }
}
