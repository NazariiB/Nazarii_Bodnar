package com.example.controller;

import com.example.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String itemNotFoundException(ItemNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exception(Exception exception) {
        return exception.getMessage();
    }
}
