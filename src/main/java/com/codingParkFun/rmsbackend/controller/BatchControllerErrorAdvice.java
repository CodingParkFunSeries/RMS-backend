package com.codingParkFun.rmsbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.codingParkFun.rmsbackend.exception.SchoolIdMismatchException;

@ControllerAdvice
public class BatchControllerErrorAdvice {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public void handle() {}
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({SchoolIdMismatchException.class})
    public void handle(SchoolIdMismatchException e) {
	}
	
}
