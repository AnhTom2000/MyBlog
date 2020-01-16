package cc.ccocc.pojo;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created on 22:07  15/01/2020
 * Description:
 *
 * @author Weleness
 */
@Data
public class Article {

    private Integer a_id;
    private String a_name;
    private String a_text;
    private Date a_createTime;
    private String a_admin;
    private List<Tag> tag;
    private Integer a_viewNums;
    private Integer a_likeNums;
    // mysql 的时间函数 除了 DATE（）  其他都返回LONG类型  这里可以直接用String接收
    private String a_year;
    private String a_month;
}
