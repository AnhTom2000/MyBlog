package cc.ccocc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 13:14  18/01/2020
 * Description:
 *
 * @author Weleness
 */
@Data
public class ResultDTO implements Serializable {

    private static final long serialVersionUID = 654654654L;

    private Integer code;

    private String message;

    private boolean status;

    public ResultDTO(Integer code, String message, boolean status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
