package com.rationcenter.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpceptionControllerAdvise {
    @ExceptionHandler(value = CustomExceptions.class)
    public final ResponseEntity<String> handleCustomException(CustomExceptions exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AuthenticationFailedException.class)
    public final ResponseEntity<String> handleAuthFailException(AuthenticationFailedException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
