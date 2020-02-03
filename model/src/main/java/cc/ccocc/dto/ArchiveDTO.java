package cc.ccocc.dto;

import cc.ccocc.pojo.Archive;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 21:09  03/02/2020
 * Description:
 *
 * @author Weleness
 */
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveDTO implements Serializable {
    private static final long serialVersionUID = 5489496816521L;

    private int id;

    private String archiveName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArchiveDTO)) return false;
        ArchiveDTO that = (ArchiveDTO) o;
        return id == that.id &&
                Objects.equals(archiveName, that.archiveName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, archiveName);
    }
}
