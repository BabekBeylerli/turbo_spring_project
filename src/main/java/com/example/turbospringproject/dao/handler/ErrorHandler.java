package com.example.turbospringproject.dao.handler;

import com.example.turbospringproject.exception.NotFoundException;
import com.example.turbospringproject.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    private ExceptionDto handler(NotFoundException notFoundException) {
        return new ExceptionDto(notFoundException.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionDto handler(Exception exception) {
        return new ExceptionDto(exception.getMessage());
    }

}
