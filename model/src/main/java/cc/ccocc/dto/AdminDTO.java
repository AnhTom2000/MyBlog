package cc.ccocc.dto;

import lombok.*;

/**
 * Created on 16:22  11/02/2020
 * Description:
 *
 * @author Weleness
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO<T> {

        Integer code;

        String message;

        T data;

        Integer total;

        Boolean status;
}
