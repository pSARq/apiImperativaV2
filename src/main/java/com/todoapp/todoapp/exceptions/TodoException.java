package com.todoapp.todoapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TodoException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public TodoException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
