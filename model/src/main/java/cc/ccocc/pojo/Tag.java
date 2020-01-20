package cc.ccocc.pojo;

import lombok.*;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;

/**
 * Created on 23:05  15/01/2020
 * Description:
 *
 * @author Weleness
 */

@Getter
@Setter
@ToString
@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {

    private static final long serialVersionUID = 65416516517L;



    private  Long tag_id;
    private  String tag_name;
}
