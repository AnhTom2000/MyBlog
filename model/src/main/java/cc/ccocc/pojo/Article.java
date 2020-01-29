package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created on 22:07  15/01/2020
 * Description:
 *  文章类
 * @author Weleness
 */
@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class Article implements Serializable {
    private static final long serialVersionUID = 8498159619L;
    //文章id
    @JsonSerialize(using= ToStringSerializer.class)
    private Long a_id;
    //文章标题
    private String a_Title;
    // 用户
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
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return markdown == article.markdown &&
                Objects.equals(a_id, article.a_id) &&
                Objects.equals(a_Title, article.a_Title) &&
                Objects.equals(user, article.user) &&
                Objects.equals(a_text, article.a_text) &&
                Objects.equals(a_createTime, article.a_createTime) &&
                Objects.equals(a_last_update, article.a_last_update) &&
                Objects.equals(tags, article.tags) &&
                Objects.equals(a_viewNums, article.a_viewNums) &&
                Objects.equals(a_likeNums, article.a_likeNums) &&
                Objects.equals(a_year, article.a_year) &&
                Objects.equals(a_month, article.a_month) &&
                Objects.equals(category, article.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a_id, a_Title, user, a_text, markdown, a_createTime, a_last_update, tags, a_viewNums, a_likeNums, a_year, a_month, category);
    }
}
