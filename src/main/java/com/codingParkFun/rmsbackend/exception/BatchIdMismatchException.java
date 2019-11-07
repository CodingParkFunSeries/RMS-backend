package com.codingParkFun.rmsbackend.exception;

public class BatchIdMismatchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BatchIdMismatchException(String message) {
        super(message);
    }

}