package cc.ccocc.utils.result;

/**
 * Created on 18:05  18/01/2020
 * Description:
 *  常用状态码
 * @author Weleness
 */
public enum ResultCode {
    //正常
    OK_CODE(200),

    //重定向
    REDIRECT_CODE(300),

    //客户端错误
    CLIENT_ERROR_CODE(400),

    //未授权错误
    UNAUTHORIZED_CODE(401),

    //404
    NOT_FOUND_CODE(404),

    //server错误
    SERVER_ERROR_CODE(500);

    /**
     * 构造函数
     * @param code 状态码
     */
    private ResultCode(Integer code)
    {
        this.code = code;
    }

    //状态码
    private Integer code;

    public Integer getCode()
    {
        return code;
    }
}
