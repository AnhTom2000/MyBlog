package cc.ccocc.dto;

import cc.ccocc.pojo.WebInfo;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    private static final long serialVersionUID = -654654654L;

    public static final Integer SUCCESS_CODE = 1;
    public static final Integer ERROR_CODE = -1;

    private Integer code;
    private String msg;




}
