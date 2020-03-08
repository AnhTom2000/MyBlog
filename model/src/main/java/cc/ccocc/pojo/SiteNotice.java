package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 22:32  15/02/2020
 * Description:
 *
 * @author Weleness
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class SiteNotice implements Serializable {
    private static  final  long serialVersionUID = 51651651L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long siteNoticeId;

    private String siteNoticeContent;

    private LocalDateTime createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SiteNotice)) return false;
        SiteNotice that = (SiteNotice) o;
        return Objects.equals(siteNoticeId, that.siteNoticeId) &&
                Objects.equals(siteNoticeContent, that.siteNoticeContent) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteNoticeId, siteNoticeContent, createTime);
    }
}
