package com.codingParkFun.rmsbackend.exception;

public class IdDoesNotExistException extends RuntimeException {
    public IdDoesNotExistException( String message ) {
        super( message );
    }
}
