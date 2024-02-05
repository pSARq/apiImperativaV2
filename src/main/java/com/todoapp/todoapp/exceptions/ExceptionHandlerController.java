package com.todoapp.todoapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TodoException.class})
    protected ResponseEntity<Object> handleConflict(TodoException todoException, WebRequest webRequest) {
        String bodyOfResponse = todoException.getMessage();
        return handleExceptionInternal(
                todoException,
                bodyOfResponse,
                new HttpHeaders(),
                todoException.getHttpStatus(),
                webRequest
        );
    }

}
