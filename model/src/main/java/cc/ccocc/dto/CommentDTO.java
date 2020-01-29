package cc.ccocc.dto;

import cc.ccocc.pojo.Article;
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
@JsonIgnoreProperties(value = {"handler"})// json的序列化注解，序列化的时候将long序列化为String 防止js的精度丢失，js大概是17位 我评论的雪花id是19位
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 365161651L;

    // 评论的主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long commentId;
    // 评论的用户
    private User user;
    // 被评论的文章主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Article article;
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
                Objects.equals(article, that.article) &&
                Objects.equals(commentContent, that.commentContent) &&
                Objects.equals(comment_like_count, that.comment_like_count) &&
                Objects.equals(replies, that.replies) &&
                Objects.equals(commentTime, that.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, user, article, commentContent, comment_like_count, replies, commentTime);
    }
}
