package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

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
    // 评论总数统计
    private int comment_Count;
    // 留言总数统计
    private int leaveSay_Count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Counts)) return false;
        Counts counts = (Counts) o;
        return article_Count == counts.article_Count &&
                tag_Count == counts.tag_Count &&
                comment_Count == counts.comment_Count &&
                leaveSay_Count == counts.leaveSay_Count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(article_Count, tag_Count, comment_Count, leaveSay_Count);
    }
}
