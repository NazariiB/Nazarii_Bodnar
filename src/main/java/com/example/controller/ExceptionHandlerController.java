package com.example.controller;

import com.example.exception.ItemExistException;
import com.example.exception.ItemNotFoundException;
import com.example.exception.NoFreeSeatsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(ItemNotFoundException ex) {
        System.out.println(Arrays.toString(ex.getStackTrace()));
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ItemExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String alreadyExist(ItemExistException ex) {
        System.out.println(Arrays.toString(ex.getStackTrace()));
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NoFreeSeatsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String noFreeSeats(NoFreeSeatsException ex) {
        System.out.println(Arrays.toString(ex.getStackTrace()));
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String general(Exception ex) {
        System.out.println(Arrays.toString(ex.getStackTrace()));
        return ex.getMessage();
    }

}
