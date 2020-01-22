package cc.ccocc.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 13:14  18/01/2020
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
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = 654654654L;

    private Integer code;

    private String message;

    private boolean status;




}
