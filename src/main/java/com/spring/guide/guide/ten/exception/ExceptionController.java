package com.spring.guide.guide.ten.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping("/exception/v1/test")
    public ResponseEntity<String> exceptionTest() throws BusinessException {
        throw new BusinessException("에러 발생!", HttpStatus.BAD_REQUEST);
    }
}
