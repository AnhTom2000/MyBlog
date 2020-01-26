package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created on 22:06  25/01/2020
 * Description:
 * 评论类
 *
 * @author Weleness
 */
@Getter
@Setter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    // 评论的主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long commentId;
    // 评论的用户
    private User user;
    // 被评论的文章主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long articleId;
    // 评论的点赞数
    private Integer comment_like_count;
    // 评论内容
    private String commentContent;
    // 这条评论的所有回复
    private List<Reply> replies;
    // 评论时间
    private LocalDateTime commentTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) &&
                Objects.equals(user, comment.user) &&
                Objects.equals(articleId, comment.articleId) &&
                Objects.equals(comment_like_count, comment.comment_like_count) &&
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(replies, comment.replies) &&
                Objects.equals(commentTime, comment.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, user, articleId, comment_like_count, commentContent, replies, commentTime);
    }
}
