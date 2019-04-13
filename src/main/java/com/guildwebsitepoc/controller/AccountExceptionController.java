package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.exception.AccountAlreadyExistsException;
import com.guildwebsitepoc.exception.AccountIdMismatchException;
import com.guildwebsitepoc.exception.AccountNotFoundException;
import com.guildwebsitepoc.exception.AccountPasswordMismatchException;
import com.guildwebsitepoc.model.GenericErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionController {

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountNotFoundException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(HttpStatus.NOT_FOUND.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountAlreadyExistsException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountIdMismatchException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountPasswordMismatchException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(HttpStatus.BAD_REQUEST.value(),
                                                                             exception.getMessage(),
                                                                             System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
