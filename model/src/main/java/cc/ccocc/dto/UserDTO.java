package cc.ccocc.dto;

import cc.ccocc.pojo.Article;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Created on 15:32  21/01/2020
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
public class UserDTO implements Serializable {


    //序列化ID
    private static final long serialVersionUID = -65416516517L;

    //用户ID
    @JsonSerialize(using= ToStringSerializer.class)
    private Long userId;

    //用户名
    private String userName;

    //用户头像地址
    private String avatarUrl;

    //用户手机号
    private String phone;

    //用户邮箱
    private String email;

    //用户性别
    private Boolean gender;

    //用户年龄
    private Short age;

    //用户地区
    private String area;

    //用户职业
    private String profession;

    //用户简介
    private String description;

    //用户的文章数量
    private Integer articleCount;

    //用户的读者数量
    private Integer followerCount;

    //用户的登录次数
    private Integer loginCount;

    //用户上次登录的时间
    private LocalDateTime lastLogin;

    //用户上次更改账号的时间
    private LocalDateTime lastUpdate;

    //账号创建的时间
    private LocalDateTime createTime;

    //用户消息数量
    private Integer messageCount;


    //第三方认证ID
    private Long oauthId;

    //用户账号是否被锁定
    private Boolean locked;




}
