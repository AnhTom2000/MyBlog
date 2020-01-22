package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created on 22:50  20/01/2020
 * Description:
 * 用户实体类
 *
 * @author Weleness
 */
@Setter
@Getter
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 3213516541L;

    private Long userId;

    private String userName;

    private String avatarUrl;

    private String password;

    private String salt;

    private String phone;

    private String email;

    private Boolean gender;

    private Short age;

    private String area;

    private String profession;

    private String description;

    private Integer articleCount;

    private Integer followerCount;

    private Integer loginCount;

    private LocalDateTime lastLogin;

    private LocalDateTime lastUpdate;

    private LocalDateTime createTime;

    private Boolean locked;
    //用户消息数量
    private Integer messageCount;

    //第三方认证ID
    private Long oauthId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(email, user.email) &&
                Objects.equals(lastLogin, user.lastLogin) &&
                Objects.equals(lastUpdate, user.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, password, salt, lastLogin, lastUpdate);
    }
}
