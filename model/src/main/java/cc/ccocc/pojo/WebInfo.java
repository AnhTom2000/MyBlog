package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created on 12:57  18/01/2020
 * Description:
 *  状态dto对象
 * @author Weleness
 */

@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WebInfo implements Serializable {
    private static final long serialVersionUID = 135168549681L;

    private Integer code;
    private String msg;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebInfo)) return false;
        WebInfo webInfo = (WebInfo) o;
        return Objects.equals(code, webInfo.code) &&
                Objects.equals(msg, webInfo.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg);
    }
}
