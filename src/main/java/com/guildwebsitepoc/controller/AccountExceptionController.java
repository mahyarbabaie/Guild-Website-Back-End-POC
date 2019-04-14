package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.exception.AccountAlreadyExistsException;
import com.guildwebsitepoc.exception.AccountIdMismatchException;
import com.guildwebsitepoc.exception.AccountNotFoundException;
import com.guildwebsitepoc.exception.AccountPasswordMismatchException;
import com.guildwebsitepoc.model.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionController {

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(AccountNotFoundException exception) {

        GenericResponse genericResponse = new GenericResponse(HttpStatus.NOT_FOUND.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(AccountAlreadyExistsException exception) {

        GenericResponse genericResponse = new GenericResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(AccountIdMismatchException exception) {

        GenericResponse genericResponse = new GenericResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericResponse> handleException(AccountPasswordMismatchException exception) {

        GenericResponse genericResponse = new GenericResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
    }
}
