package cc.ccocc.dto;

import cc.ccocc.pojo.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 21:46  26/01/2020
 * Description:
 *
 * @author Weleness
 */
@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class ReplyDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    // 评论回复的主键
    private Integer replyId;
    // 评论回复的用户
    private User user;
    // 评论回复文章的主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long articleId;
    // 评论的用户
    private User replyUser;
    // 评论回复评论的主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long commentId;
    // 评论回复的时间
    private LocalDateTime replyTime;
    // 评论回复的内容
    private String replyContent;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplyDTO)) return false;
        ReplyDTO replyDTO = (ReplyDTO) o;
        return Objects.equals(replyId, replyDTO.replyId) &&
                Objects.equals(user, replyDTO.user) &&
                Objects.equals(articleId, replyDTO.articleId) &&
                Objects.equals(replyUser, replyDTO.replyUser) &&
                Objects.equals(replyTime, replyDTO.replyTime) &&
                Objects.equals(replyContent, replyDTO.replyContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(replyId, user, articleId, replyUser, replyTime, replyContent);
    }
}
