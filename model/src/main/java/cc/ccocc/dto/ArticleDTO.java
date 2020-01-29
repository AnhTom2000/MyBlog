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
    // 用户id
    private User user;
    //文章内容
    private String a_text;
    //是否是markdown写的
    private boolean markdown;
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

    //文章所属年份
    private String a_year;   // mysql 的时间函数 除了 DATE（）  其他都返回LONG类型  这里可以直接用String接收
    //文章所属月份
    private String a_month;
    // 文章类别
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleDTO)) return false;
        ArticleDTO that = (ArticleDTO) o;
        return markdown == that.markdown &&
                Objects.equals(a_id, that.a_id) &&
                Objects.equals(a_Title, that.a_Title) &&
                Objects.equals(user, that.user) &&
                Objects.equals(a_text, that.a_text) &&
                Objects.equals(a_createTime, that.a_createTime) &&
                Objects.equals(a_last_update, that.a_last_update) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(a_viewNums, that.a_viewNums) &&
                Objects.equals(a_likeNums, that.a_likeNums) &&
                Objects.equals(a_year, that.a_year) &&
                Objects.equals(a_month, that.a_month) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a_id, a_Title, user, a_text, markdown, a_createTime, a_last_update, tags, a_viewNums, a_likeNums, a_year, a_month, category);
    }
}
