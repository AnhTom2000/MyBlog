package cc.ccocc.exception;

/**
 * Created on 16:11  18/02/2020
 * Description:
 *  TODO        Github 认证异常
 * @author Weleness
 */

public class GitHubAuthenticationException extends AuthenticationException {

    public GitHubAuthenticationException() {
        super();
    }

    public GitHubAuthenticationException(String message) {
        super(message);
    }

    public GitHubAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public GitHubAuthenticationException(Throwable cause) {
        super(cause);
    }

    protected GitHubAuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
