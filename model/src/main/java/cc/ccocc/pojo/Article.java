package cc.ccocc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 22:07  15/01/2020
 * Description:
 *  文章类
 * @author Weleness
 */
@Data
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    //文章id
    private Long a_id;
    //文章标题
    private String a_Title;
    // 用户id
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
