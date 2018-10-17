package com.eric.grace.utils.exceptions;

/**
 * FtpException:
 *
 * @author: MrServer
 * @since: 2018/1/12 下午2:42
 */
public class FtpException extends RuntimeException {

    public FtpException() {
    }

    public FtpException(String message) {
        super(message);
    }

    public FtpException(String message, Throwable cause) {
        super(message, cause);
    }

    public FtpException(Throwable cause) {
        super(cause);
    }

    public FtpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}