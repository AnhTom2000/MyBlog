package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 23:05  15/01/2020
 * Description:
 *
 * @author Weleness
 */

@Getter
@Setter
@ToString
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag implements Serializable {

    private static final long serialVersionUID = 65416516517L;


    @JsonSerialize(using= ToStringSerializer.class)
    private  Long tag_id;
    private  String tag_name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(tag_id, tag.tag_id) &&
                Objects.equals(tag_name, tag.tag_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag_id, tag_name);
    }
}
