package cc.ccocc.exception;

/**
 * Created on 23:13  26/02/2020
 * Description:
 *
 * @author Weleness
 */

public class NoFundException extends ApplicationException {

    public NoFundException() {
        super();
    }

    public NoFundException(String message) {
        super(message);
    }

    public NoFundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFundException(Throwable cause) {
        super(cause);
    }

    protected NoFundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
