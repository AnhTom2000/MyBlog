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
 * Created on 23:54  19/02/2020
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
public class QuestionDTO implements Serializable {

    private static final long serialVersionUID = 13165165L;

    // 反馈id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long questionId;
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
        if (!(o instanceof QuestionDTO)) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(questionTitle, that.questionTitle) &&
                Objects.equals(questionContent, that.questionContent) &&
                Objects.equals(replyContent, that.replyContent) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(replyTime, that.replyTime) &&
                Objects.equals(locked, that.locked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, user, questionTitle, questionContent, replyContent, createTime, replyTime, locked);
    }
}
