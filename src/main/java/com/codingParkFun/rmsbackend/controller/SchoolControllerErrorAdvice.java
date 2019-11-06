package com.codingParkFun.rmsbackend.controller;

import com.codingParkFun.rmsbackend.exception.IdDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SchoolControllerErrorAdvice {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public void handle() {}


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IdDoesNotExistException.class})
    public void handle(IdDoesNotExistException e) {
    }

}
