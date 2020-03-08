package cc.ccocc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 21:10  19/02/2020
 * Description:
 *
 * @author Weleness
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class SiteNoticeDTO implements Serializable {

    private static  final  long serialVersionUID = 5165151L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long siteNoticeId;

    private String siteNoticeContent;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SiteNoticeDTO)) return false;
        SiteNoticeDTO that = (SiteNoticeDTO) o;
        return Objects.equals(siteNoticeId, that.siteNoticeId) &&
                Objects.equals(siteNoticeContent, that.siteNoticeContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteNoticeId, siteNoticeContent);
    }
}
