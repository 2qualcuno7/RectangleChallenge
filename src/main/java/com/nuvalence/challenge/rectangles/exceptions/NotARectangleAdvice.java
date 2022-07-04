package com.nuvalence.challenge.rectangles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotARectangleAdvice {
    @ResponseBody
    @ExceptionHandler(NotARectangleException.class)
    String employeeNotFoundHandler(NotARectangleException e) {
        return e.getMessage();
    }
}
