package cc.ccocc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created on 19:44  12/02/2020
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
public class SupperAdmin implements Serializable {

    private static final  long serialVersionUID = 65446516L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long adminId;

    private String adminName;

    private String avatarUrl;

    private String password;

    private String phone;

    private String email;

    private Boolean gender;

    private Short age;

    private String area;

    private Integer loginCount;

    private LocalDateTime createTime;

    private LocalDateTime lastLogin;

    private  Integer messageCount;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupperAdmin)) return false;
        SupperAdmin that = (SupperAdmin) o;
        return Objects.equals(adminId, that.adminId) &&
                Objects.equals(adminName, that.adminName) &&
                Objects.equals(avatarUrl, that.avatarUrl) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(age, that.age) &&
                Objects.equals(area, that.area) &&
                Objects.equals(loginCount, that.loginCount) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastLogin, that.lastLogin) &&
                Objects.equals(messageCount, that.messageCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, avatarUrl, password, phone, email, gender, age, area, loginCount, createTime, lastLogin, messageCount);
    }
}
