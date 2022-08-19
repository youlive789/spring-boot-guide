package com.spring.guide.guide.ten.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BusinessException extends Exception {
    private String message;
    private HttpStatus code;

    public BusinessException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }
}
