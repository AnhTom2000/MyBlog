package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * Created on 15:59  16/01/2020
 * Description:
 * 统计类
 * @author Weleness
 */
@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Counts implements Serializable {

    private static final long serialVersionUID = -8498159619L;
    // 文章总数统计
    private int article_Count;
    // 标签总数统计
    private int tag_Count;
    // 留言总数统计
    private int comment_Count;
}
