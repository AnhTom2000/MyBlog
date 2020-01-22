package cc.ccocc.pojo;

import com.sun.xml.internal.ws.api.pipe.Fiber;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 22:45  20/01/2020
 * Description:
 *  第三方登陆实体类
 * @author Weleness
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
//注解用来配置lombok如何产生和显示getters和setters的方法。
@Accessors(chain = true) // 2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。默认是假。如果fluent=true，那么chain默认为真。
public class Oauth implements Serializable {

    private static final  Long serialVersionUID = -3213516541L;
    private Long oauthId;

    private String oauthType;

    private String githubOpenId;

    private String qqOpenId;

    private String weChatOpenId;

    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oauth oauth = (Oauth) o;
        return Objects.equals(oauthId, oauth.oauthId) &&
                Objects.equals(oauthType, oauth.oauthType) &&
                Objects.equals(githubOpenId, oauth.githubOpenId) &&
                Objects.equals(qqOpenId, oauth.qqOpenId) &&
                Objects.equals(weChatOpenId, oauth.weChatOpenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauthId, oauthType, githubOpenId, qqOpenId, weChatOpenId);
    }
}
