package com.guildwebsitepoc.exception;

public class AccountIdMismatchException extends RuntimeException {

    public AccountIdMismatchException() {}

    public AccountIdMismatchException(String message) { super(message); }

    public AccountIdMismatchException(Throwable cause) { super(cause); }

    public AccountIdMismatchException(String message,
                                         Throwable cause) { super(message, cause); }

    public AccountIdMismatchException(String message,
                                         Throwable cause,
                                         boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
