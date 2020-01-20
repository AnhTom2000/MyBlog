package cc.ccocc.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created on 10:23  20/01/2020
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
public class UploadImgDTO implements Serializable {

    private static final long serialVersionUID =2165465615L;



     // 状态码
    private Integer success;
    // 记录状态信息
    private String message;
    // 如果上传成功，返回图片的地址
    private String url;


}
