package cc.ccocc.pojo;

import lombok.Data;

/**
 * Created on 15:59  16/01/2020
 * Description:
 * 统计类
 * @author Weleness
 */
@Data
public class Counts {

    // 文章总数统计
    private int article_Count;
    // 标签总数统计
    private int tag_Count;
    // 留言总数统计
    private int comment_Count;
}
