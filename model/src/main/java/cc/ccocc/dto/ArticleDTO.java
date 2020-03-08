package cc.ccocc.dto;

import cc.ccocc.pojo.Category;
import cc.ccocc.pojo.Tag;
import cc.ccocc.pojo.User;
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
 * Created on 23:07  23/01/2020
 * Description:
 *  文章dto对象
 * @author Weleness
 */

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class ArticleDTO implements Serializable {

    private static final long serialVersionUID = 7658159619L;

    //文章id
    @JsonSerialize(using= ToStringSerializer.class)
    private Long a_id;
    //文章标题
    private String a_Title;
    //文章归档ID
    @JsonSerialize(using= ToStringSerializer.class)
    private Long archiveId;
    // 用户id
    private User user;
    //文章内容
    private String a_text;
    //是否是markdown写的
    private Boolean markdown;
    //文章发布时间
    private LocalDateTime a_createTime;
    //文章最后一次修改时间
    private LocalDateTime a_last_update;
    //文章标签集合
    private List<Tag> tags;
    //喜欢人数
    private Integer a_viewNums;
    //观看人数
    private Integer a_likeNums;
    // 文章类别
    private Category category;
    // 文章是否审核通过
    private Boolean checked;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleDTO)) return false;
        ArticleDTO that = (ArticleDTO) o;
        return Objects.equals(a_id, that.a_id) &&
                Objects.equals(a_Title, that.a_Title) &&
                Objects.equals(archiveId, that.archiveId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(a_text, that.a_text) &&
                Objects.equals(markdown, that.markdown) &&
                Objects.equals(a_createTime, that.a_createTime) &&
                Objects.equals(a_last_update, that.a_last_update) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(a_viewNums, that.a_viewNums) &&
                Objects.equals(a_likeNums, that.a_likeNums) &&
                Objects.equals(category, that.category) &&
                Objects.equals(checked, that.checked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a_id, a_Title, archiveId, user, a_text, markdown, a_createTime, a_last_update, tags, a_viewNums, a_likeNums, category, checked);
    }
}
