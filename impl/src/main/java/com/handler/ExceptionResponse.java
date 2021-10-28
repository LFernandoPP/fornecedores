package com.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class ExceptionResponse {

    private String name;
    private Object cause;
    private LocalDateTime timestamp;
    private HttpStatus httpStatus;
}