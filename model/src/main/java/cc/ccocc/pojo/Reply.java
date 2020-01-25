package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 21:53  25/01/2020
 * Description:
 *
 * @author Weleness
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply implements Serializable {

    private static final long serialVersionUID = 1561654564L;

    // 评论回复的主键
    private Integer replyId;
    // 评论回复的用户
    private User user;
    // 评论回复文章的主键
    private Long articleId;
    // 评论的主键
    private Long commentId;
    // 评论回复的时间
    private LocalDateTime replyTime;
    // 评论回复的内容
    private String replyContent;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reply)) return false;
        Reply reply = (Reply) o;
        return Objects.equals(replyId, reply.replyId) &&
                Objects.equals(user, reply.user) &&
                Objects.equals(articleId, reply.articleId) &&
                Objects.equals(commentId, reply.commentId) &&
                Objects.equals(replyTime, reply.replyTime) &&
                Objects.equals(replyContent, reply.replyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, user, articleId, commentId, replyTime, replyContent);
    }
}
