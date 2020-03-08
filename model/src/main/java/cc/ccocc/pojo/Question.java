package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 22:51  13/02/2020
 * Description:
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
public class Question implements Serializable {

    private static final long serialVersionUID = 5651651L;

        // 反馈id
        @JsonSerialize(using = ToStringSerializer.class)
        private Long questionId;
        // 反馈的用户id
        @JsonSerialize(using = ToStringSerializer.class)
        private Long userId;
        // 反馈的用户信息
        private User user;
        // 反馈标题
        private String questionTitle;
        // 反馈内容
        private String questionContent;
        // 反馈回复内容
        private String replyContent;
        // 创建时间
        private LocalDateTime createTime;
        // 回复时间
        private LocalDateTime replyTime;
        // 是否审核
        private Boolean locked;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(questionId, question.questionId) &&
                Objects.equals(userId, question.userId) &&
                Objects.equals(user, question.user) &&
                Objects.equals(questionTitle, question.questionTitle) &&
                Objects.equals(questionContent, question.questionContent) &&
                Objects.equals(replyContent, question.replyContent) &&
                Objects.equals(createTime, question.createTime) &&
                Objects.equals(replyTime, question.replyTime) &&
                Objects.equals(locked, question.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, userId, user, questionTitle, questionContent, replyContent, createTime, replyTime, locked);
    }
}
