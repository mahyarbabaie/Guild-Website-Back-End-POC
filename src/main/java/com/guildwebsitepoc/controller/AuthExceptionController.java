package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.exception.JwtTokenExpiredException;
import com.guildwebsitepoc.model.GenericErrorResponse;
import com.guildwebsitepoc.utility.ErrorCodeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionController {

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(JwtTokenExpiredException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(
                HttpStatus.UNAUTHORIZED.value(),
                ErrorCodeConstants.AUTH_UNAUTHORIZED,
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.UNAUTHORIZED);
    }
}
