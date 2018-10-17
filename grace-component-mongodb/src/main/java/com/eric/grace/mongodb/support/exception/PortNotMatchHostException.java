package com.eric.grace.mongodb.support.exception;

/**
 * PortNotMatchHostException:
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:18
 */
public class PortNotMatchHostException extends RuntimeException {
    public PortNotMatchHostException() {
        super();
    }

    public PortNotMatchHostException(String message) {
        super(message);
    }
}
