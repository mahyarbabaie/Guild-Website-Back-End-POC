package com.guildwebsitepoc.exception;

public class AccountPasswordMismatchException extends RuntimeException {

    public AccountPasswordMismatchException() {}

    public AccountPasswordMismatchException(String message) { super(message); }

    public AccountPasswordMismatchException(Throwable cause) { super(cause); }

    public AccountPasswordMismatchException(String message,
                                            Throwable cause) { super(message, cause); }

    public AccountPasswordMismatchException(String message,
                                            Throwable cause,
                                            boolean enableSuppression,
                                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
