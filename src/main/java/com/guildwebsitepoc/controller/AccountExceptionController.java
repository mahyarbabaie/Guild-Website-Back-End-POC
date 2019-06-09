package com.guildwebsitepoc.controller;

import com.guildwebsitepoc.exception.*;
import com.guildwebsitepoc.model.GenericErrorResponse;
import com.guildwebsitepoc.utility.ErrorCodeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionController {

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountNotFoundException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ErrorCodeConstants.ACCOUNT_NOT_FOUND,
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountUsernameAlreadyExistsException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ErrorCodeConstants.ACCOUNT_USERNAME_ALREADY_EXISTS,
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountEmailAlreadyExistsException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ErrorCodeConstants.ACCOUNT_EMAIL_ALREADY_EXISTS,
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountIdMismatchException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ErrorCodeConstants.ACCOUNT_ID_MISMATCH,
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<GenericErrorResponse> handleException(AccountPasswordMismatchException exception) {

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ErrorCodeConstants.ACCOUNT_PASSWORD_MISMATCH,
                exception.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
