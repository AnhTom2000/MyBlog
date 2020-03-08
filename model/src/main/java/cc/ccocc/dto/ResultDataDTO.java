package cc.ccocc.dto;

import lombok.*;
import org.springframework.cglib.beans.BeanCopier;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 21:45  10/02/2020
 * Description:
 *
 * @author Weleness
 */
//@Builder //声明实体，表示可以进行Builder方式初始化，对外保持private setter 而对属性的赋值采用builder的方式
@ToString
@NoArgsConstructor
public class ResultDataDTO<T> implements Serializable {

    private static final long serialVersionUID = 654654654L;

    private Integer code;

    private String message;

    private boolean status;

    private T data;

    private BeanCopier beanCopier;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultDataDTO)) return false;
        ResultDataDTO<?> that = (ResultDataDTO<?>) o;
        return status == that.status &&
                Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, status, data);
    }
}
