package cc.ccocc.dto;

import cc.ccocc.pojo.Link;
import cc.ccocc.pojo.WebInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created on 12:57  18/01/2020
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
public class WebInfoDTO implements Serializable {

    //网站信息ID
    private Integer webInfoId;

    //meta:description
    private String description;

    //meta:keywords
    private String keywords;

    //备案信息
    private String icpInfo;

    //copyright信息
    private String copyright;

    //logo url
    private String logoUrl;

    // 友链
    private List<Link> links;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebInfoDTO)) return false;
        WebInfoDTO that = (WebInfoDTO) o;
        return Objects.equals(webInfoId, that.webInfoId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(keywords, that.keywords) &&
                Objects.equals(icpInfo, that.icpInfo) &&
                Objects.equals(copyright, that.copyright) &&
                Objects.equals(logoUrl, that.logoUrl) &&
                Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webInfoId, description, keywords, icpInfo, copyright, logoUrl, links);
    }
}
