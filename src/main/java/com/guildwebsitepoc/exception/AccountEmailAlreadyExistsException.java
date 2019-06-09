package com.guildwebsitepoc.exception;

public class AccountEmailAlreadyExistsException extends RuntimeException {

    public AccountEmailAlreadyExistsException() {}

    public AccountEmailAlreadyExistsException(String message) { super(message); }

    public AccountEmailAlreadyExistsException(Throwable cause) { super(cause); }

    public AccountEmailAlreadyExistsException(String message,
                                                 Throwable cause) { super(message, cause); }

    public AccountEmailAlreadyExistsException(String message,
                                                 Throwable cause,
                                                 boolean enableSuppression,
                                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}