package cc.ccocc.dto;

import cc.ccocc.pojo.Comment;
import cc.ccocc.pojo.Reply;
import cc.ccocc.pojo.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created on 21:36  25/01/2020
 * Description:
 * 评论dto对象
 *
 * @author Weleness
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 365161651L;

    // 评论的主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long commentId;
    // 评论的用户
    private User user;
    // 被评论的文章主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long articleId;
    // 评论内容
    private String commentContent;
    // 评论的点赞数
    private Integer comment_like_count;
    // 这条评论的所有回复
    private List<Reply> replies;
    // 评论时间
    private LocalDateTime commentTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentDTO)) return false;
        CommentDTO that = (CommentDTO) o;
        return Objects.equals(commentId, that.commentId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(commentContent, that.commentContent) &&
                Objects.equals(comment_like_count, that.comment_like_count) &&
                Objects.equals(replies, that.replies) &&
                Objects.equals(commentTime, that.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, user, articleId, commentContent, comment_like_count, replies, commentTime);
    }
}
