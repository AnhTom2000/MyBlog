package cc.ccocc.dto;

import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Comment;
import cc.ccocc.pojo.LikeNotification;
import cc.ccocc.pojo.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 21:26  07/02/2020
 * Description:
 *  消息推送对象的DTO对象
 * @author Weleness
 */
@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class LikeNotificationDTO implements Serializable {

    private static  final  long serialVersionUTD = 13516514651L;

    // 主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long likeNotificationId;

    // 点赞的用户主键
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    // 被点赞的用户主键
    @JsonSerialize(using = ToStringSerializer.class)
    private Long authId;
    //点赞的用户
    private User user;
    // 点赞的文章主键
    @JsonSerialize(using = ToStringSerializer.class)
    private Long articleId;
    // 点赞的文章
    private String articleTitle;
    // 点赞的评论主键
    @JsonSerialize(using = ToStringSerializer.class)
    private Long commentId;
    // 评论内容
    private String commentContent;
    // 消息类型
    private String type;
    // 消息创建时间
    private LocalDateTime createTime;
    // 标记是否已读
    private Boolean markRead;
    // 未读消息数量
    private Integer UnMarkStatics;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikeNotificationDTO)) return false;
        LikeNotificationDTO that = (LikeNotificationDTO) o;
        return Objects.equals(likeNotificationId, that.likeNotificationId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(authId, that.authId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(articleTitle, that.articleTitle) &&
                Objects.equals(commentId, that.commentId) &&
                Objects.equals(commentContent, that.commentContent) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(markRead, that.markRead) &&
                Objects.equals(UnMarkStatics, that.UnMarkStatics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeNotificationId, userId, authId, user, articleId, articleTitle, commentId, commentContent, type, createTime, markRead, UnMarkStatics);
    }
}
