package cc.ccocc.pojo;

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
@Setter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 352151651L;

    // 评论的主键
    private Long commentId;
    // 评论的用户
    private User user;
    // 被评论的文章主键
    private Long articleId;
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
                Objects.equals(commentContent, comment.commentContent) &&
                Objects.equals(replies, comment.replies) &&
                Objects.equals(commentTime, comment.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, user, articleId, commentContent, replies, commentTime);
    }
}
