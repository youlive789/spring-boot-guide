package com.spring.guide.guide.ten.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {
    
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<BusinessException> handleBusinessException(BusinessException exception, HttpServletRequest request) {
        log.debug("Exception : {}", exception);
        log.debug("request Info : {}", request.getRequestURI());

        return ResponseEntity.status(exception.getCode()).body(exception);
    }

}
