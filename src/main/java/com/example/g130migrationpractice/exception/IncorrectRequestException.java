package com.example.g130migrationpractice.exception;

public class IncorrectRequestException extends RuntimeException {

    public IncorrectRequestException() {
        super();
    }

    public IncorrectRequestException(String message) {
        super(message);
    }
}
