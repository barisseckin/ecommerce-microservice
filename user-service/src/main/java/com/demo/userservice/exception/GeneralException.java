package com.demo.userservice.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class GeneralException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public GeneralException(String message, HttpStatus httpStatus) {
        this.message =  message;
        this.httpStatus = httpStatus;
    }
}
