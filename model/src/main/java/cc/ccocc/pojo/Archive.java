package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 19:56  17/01/2020
 * Description:
 *  归档
 * @author Weleness
 */

@Setter
@Getter
@Builder//声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Archive implements Serializable {
    private static final long serialVersionUID = 5489496816521L;

    private int id;

    private String archiveName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Archive)) return false;
        Archive archive = (Archive) o;
        return id == archive.id &&
                Objects.equals(archiveName, archive.archiveName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, archiveName);
    }
}
