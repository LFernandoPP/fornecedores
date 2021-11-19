package com.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;
}
