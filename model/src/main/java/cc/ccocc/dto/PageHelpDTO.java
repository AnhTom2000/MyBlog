package cc.ccocc.dto;

import lombok.*;

import java.util.List;
import java.util.Objects;

/**
 * Created on 19:57  20/02/2020
 * Description:
 *
 * @author Weleness
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageHelpDTO<T> {
    //当前页数
    private int pageNo;
    //每页显示的记录数
    private int pageSize;
    //总页数
    private int total;
    //总页数
    private int totalPage;
    // 每页数据
    T data;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageHelpDTO)) return false;
        PageHelpDTO<?> that = (PageHelpDTO<?>) o;
        return pageNo == that.pageNo &&
                pageSize == that.pageSize &&
                total == that.total &&
                totalPage == that.totalPage &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNo, pageSize, total, totalPage, data);
    }
}
