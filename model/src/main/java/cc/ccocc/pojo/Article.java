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
 *
 * @author Weleness
 */
@Data
public class Article implements Serializable {

    private Long a_id;
    private String a_name;
    private Long u_id;
    private String a_text;
    private boolean markdown;
    private Date a_createTime;
    private List<Tag> tag;
    private Integer a_viewNums;
    private Integer a_likeNums;
    // mysql 的时间函数 除了 DATE（）  其他都返回LONG类型  这里可以直接用String接收
    private String a_year;
    private String a_month;

    private String category; // 文章类别
}
