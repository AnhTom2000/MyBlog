package cc.ccocc.exception;

/**
 * Created on 15:21  26/02/2020
 * Description:
 *
 * @author Weleness
 */

public class NoPersonSelfException extends ApplicationException {
    public NoPersonSelfException() {
        super();
    }

    public NoPersonSelfException(String message) {
        super(message);
    }

    public NoPersonSelfException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPersonSelfException(Throwable cause) {
        super(cause);
    }

    protected NoPersonSelfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
