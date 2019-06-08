package com.guildwebsitepoc.exception;

public class JwtTokenExpiredException extends RuntimeException {

    public JwtTokenExpiredException() {}

    public JwtTokenExpiredException(String message) { super(message); }

    public JwtTokenExpiredException(Throwable cause) { super(cause); }

    public JwtTokenExpiredException(String message,
                                         Throwable cause) { super(message, cause); }

    public JwtTokenExpiredException(String message,
                                         Throwable cause,
                                         boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}