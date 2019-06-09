package com.guildwebsitepoc.exception;

public class AccountUsernameAlreadyExistsException extends RuntimeException {

    public AccountUsernameAlreadyExistsException() {}

    public AccountUsernameAlreadyExistsException(String message) { super(message); }

    public AccountUsernameAlreadyExistsException(Throwable cause) { super(cause); }

    public AccountUsernameAlreadyExistsException(String message,
                                                 Throwable cause) { super(message, cause); }

    public AccountUsernameAlreadyExistsException(String message,
                                                 Throwable cause,
                                                 boolean enableSuppression,
                                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
