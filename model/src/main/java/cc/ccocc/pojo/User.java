package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
@JsonIgnoreProperties(value = {"handler"})
public class User implements Serializable {

    private static final long serialVersionUID = 3213516541L;

    // 用户主键
    @JsonSerialize(using= ToStringSerializer.class)
    private Long userId;
    // 用户名
    private String userName;
    // 用户头像地址
    private String avatarUrl;
    // 用户密码
    private String password;
    // 用户手机号
    private String phone;
    // 用户邮箱
    private String email;
    // 用户性别
    private Boolean gender;
    //用户年龄
    private Short age;
    // 用户地区
    private String area;
    // 用户职业
    private String profession;
    // 用户个人简介
    private String description;
    // 用户文章数量
    private Integer articleCount;
    // 用户标签数量
    private Integer tagCount;
    // 用户读者数量
    private Integer followerCount;
    // 用户登陆次数
    private Integer loginCount;
    // 用户最后一次登陆的时间
    private LocalDateTime lastLogin;
    // 用户最后一次修改信息的时间
    private LocalDateTime lastUpdate;
    // 用户注册时间
    private LocalDateTime createTime;
    // 用户是否被锁定
    private Boolean locked;
    //用户消息数量
    private Integer messageCount;
    //第三方认证ID
    @JsonSerialize(using= ToStringSerializer.class)
    private Long oauthId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(avatarUrl, user.avatarUrl) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(age, user.age) &&
                Objects.equals(area, user.area) &&
                Objects.equals(profession, user.profession) &&
                Objects.equals(description, user.description) &&
                Objects.equals(articleCount, user.articleCount) &&
                Objects.equals(tagCount, user.tagCount) &&
                Objects.equals(followerCount, user.followerCount) &&
                Objects.equals(loginCount, user.loginCount) &&
                Objects.equals(lastLogin, user.lastLogin) &&
                Objects.equals(lastUpdate, user.lastUpdate) &&
                Objects.equals(createTime, user.createTime) &&
                Objects.equals(locked, user.locked) &&
                Objects.equals(messageCount, user.messageCount) &&
                Objects.equals(oauthId, user.oauthId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, avatarUrl, password, phone, email, gender, age, area, profession, description, articleCount, tagCount, followerCount, loginCount, lastLogin, lastUpdate, createTime, locked, messageCount, oauthId);
    }
}
