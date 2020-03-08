package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 22:16  09/02/2020
 * Description:
 *
 * @author Weleness
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class SystemNotification implements Serializable {

    private static final long serialVersionUID = 6561651L;

    // 系统通知id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long systemNotificationId;
    // 通知的用户id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    // 通知的用户
    private User user;
    // 消息类型
    private String type;
    // 消息标题
    private String messageTitle;
    // 消息来源的id，例如文章id
    private Long sourceId;
    // 消息内容
    private String messageContent;
    // 消息创建时间
    private LocalDateTime createTime;
    // 是否已读
    private Boolean markRead;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemNotification)) return false;
        SystemNotification that = (SystemNotification) o;
        return Objects.equals(systemNotificationId, that.systemNotificationId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(type, that.type) &&
                Objects.equals(messageTitle, that.messageTitle) &&
                Objects.equals(sourceId, that.sourceId) &&
                Objects.equals(messageContent, that.messageContent) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(markRead, that.markRead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemNotificationId, userId, user, type, messageTitle, sourceId, messageContent, createTime, markRead);
    }
}
