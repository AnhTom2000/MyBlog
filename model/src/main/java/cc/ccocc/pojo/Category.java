package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 22:17  18/01/2020
 * Description:
 *  分类表
 * @author Weleness
 *
 */

@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private static final long serialVersionUID = 13521654784L;
    private  Integer categoryid; // 分类id
        private  String categoryname; // 分类名称


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(categoryid, category.categoryid) &&
                Objects.equals(categoryname, category.categoryname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryid, categoryname);
    }
}
