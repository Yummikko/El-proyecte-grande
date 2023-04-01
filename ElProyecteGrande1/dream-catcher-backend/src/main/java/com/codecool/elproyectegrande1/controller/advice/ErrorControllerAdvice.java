package com.codecool.elproyectegrande1.controller.advice;

import com.codecool.elproyectegrande1.exceptions.DreamNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(DreamNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse handleNoDream(DreamNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    private record ErrorResponse(String errorMessage) {

    }
}
