package cc.ccocc.exception;

/**
 * Created on 16:08  18/02/2020
 * Description:
 *  TODO        认证异常
 * @author Weleness
 */

public class AuthenticationException extends ApplicationException {

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    protected AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
