package cc.ccocc.dto;

import cc.ccocc.pojo.Archive;
import cc.ccocc.pojo.Article;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
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
@JsonIgnoreProperties(value = {"handler"})
public class ArchiveDTO implements Serializable {
    private static final long serialVersionUID = 5489496816521L;

    // 归档主键
    @JsonSerialize(using= ToStringSerializer.class)
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
        if (!(o instanceof ArchiveDTO)) return false;
        ArchiveDTO that = (ArchiveDTO) o;
        return Objects.equals(archive_id, that.archive_id) &&
                Objects.equals(archiveName, that.archiveName) &&
                Objects.equals(archiveYear, that.archiveYear) &&
                Objects.equals(archive_article_count, that.archive_article_count) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archive_id, archiveName, archiveYear, archive_article_count, createTime, articles);
    }
}
