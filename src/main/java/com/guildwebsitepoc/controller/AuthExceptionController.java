package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.exception.JwtTokenExpiredException;
import com.guildwebsitepoc.model.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionController {

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(JwtTokenExpiredException exception) {

        GenericResponse genericResponse = new GenericResponse(HttpStatus.UNAUTHORIZED.value(),
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericResponse, HttpStatus.UNAUTHORIZED);
    }
}
