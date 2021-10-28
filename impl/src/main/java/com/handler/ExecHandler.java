package com.handler;

import com.mongodb.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExecHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse erroInterno(Exception exception) {
        return ExceptionResponse.builder()
                .name("InternalErrorException")
                .cause(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse chaveDuplicadaException(DuplicateKeyException exception) {
        return ExceptionResponse.builder()
                .name("DuplicateKeyException")
                .cause(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse argumentoInvalidoException(MethodArgumentNotValidException exception) {
        return ExceptionResponse.builder()
                .name("MethodArgumentNotValidException")
                .cause(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
    }
}