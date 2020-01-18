package cc.ccocc.dto;

import cc.ccocc.pojo.WebInfo;
import lombok.Data;

import java.util.List;

/**
 * Created on 12:57  18/01/2020
 * Description:
 *
 * @author Weleness
 */

@Data
public class WebInfoDTO {
    public static final Integer SUCCESS_CODE = 1;
    public static final Integer ERROR_CODE = -1;

    private Integer code;
    private String msg;




}
