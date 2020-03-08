package cc.ccocc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created on 16:09  17/02/2020
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
public class SuperAdminDTO implements Serializable {

    private static final long serialVersionUID = 51651651651L;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long adminId;

    private String adminName;

    // 暂时的登陆令牌，根据这个令牌获取验证码
    private String uuid;
}
