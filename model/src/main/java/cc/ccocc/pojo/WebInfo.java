package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @Description : TODO      网站信息实体
 * @Author :    yangguang
 * @Date :      2019/12/17
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebInfo implements Serializable {
    //序列化ID
    private static final long serialVersionUID = 1463093999127802198L;
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
        if (!(o instanceof WebInfo)) return false;
        WebInfo webInfo = (WebInfo) o;
        return Objects.equals(webInfoId, webInfo.webInfoId) &&
                Objects.equals(description, webInfo.description) &&
                Objects.equals(keywords, webInfo.keywords) &&
                Objects.equals(icpInfo, webInfo.icpInfo) &&
                Objects.equals(copyright, webInfo.copyright) &&
                Objects.equals(logoUrl, webInfo.logoUrl) &&
                Objects.equals(links, webInfo.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webInfoId, description, keywords, icpInfo, copyright, logoUrl, links);
    }
}
