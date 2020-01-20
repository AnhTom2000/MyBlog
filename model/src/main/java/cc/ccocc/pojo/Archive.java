package cc.ccocc.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * Created on 19:56  17/01/2020
 * Description:
 *  归档
 * @author Weleness
 */

@Setter
@Getter
@Builder//声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Archive implements Serializable {
    private static final long serialVersionUID = 5489496816521L;

    private int id;

    private String archiveName;
}
