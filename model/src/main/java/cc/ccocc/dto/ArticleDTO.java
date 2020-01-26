package cc.ccocc.dto;

import cc.ccocc.pojo.Category;
import cc.ccocc.pojo.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
    @JsonSerialize(using=ToStringSerializer.class)
    private Long u_id;
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
}
