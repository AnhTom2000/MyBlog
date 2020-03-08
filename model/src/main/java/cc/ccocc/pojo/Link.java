package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 00:02  16/02/2020
 * Description:
 *
 * @author Weleness
 */
@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class Link implements Serializable {
    private static final long serialVersionUID = 84986516519L;


    public int linkId;

    public String linkName;

    public String href;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return linkId == link.linkId &&
                Objects.equals(linkName, link.linkName) &&
                Objects.equals(href, link.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, linkName, href);
    }
}
