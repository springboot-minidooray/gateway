package com.nhnacademy.gateway.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
