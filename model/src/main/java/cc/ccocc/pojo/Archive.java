package cc.ccocc.pojo;

import cc.ccocc.dto.ArchiveDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created on 19:56  17/01/2020
 * Description:
 * 归档
 *
 * @author Weleness
 */

@Setter
@Getter
@Builder//声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class Archive implements Serializable {
    private static final long serialVersionUID = 5489496816521L;

    // 归档主键
    @JsonSerialize(using = ToStringSerializer.class)
    private Long archive_id;
    // 归档名称
    private String archiveName;
    // 归档年份
    private String archiveYear;
    // 当前归档的文章数量
    private Integer archive_article_count;
    // 归档创建日期
    private LocalDateTime createTime;

    // 某个归档下面所属的文章
    private List<Article> articles;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Archive)) return false;
        Archive archive = (Archive) o;
        return Objects.equals(archive_id, archive.archive_id) &&
                Objects.equals(archiveName, archive.archiveName) &&
                Objects.equals(archiveYear, archive.archiveYear) &&
                Objects.equals(archive_article_count, archive.archive_article_count) &&
                Objects.equals(createTime, archive.createTime) &&
                Objects.equals(articles, archive.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archive_id, archiveName, archiveYear, archive_article_count, createTime, articles);
    }
}
