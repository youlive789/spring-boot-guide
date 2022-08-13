package com.spring.guide.guide.five;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.five.dto.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "PostController")
@RestController
@RequestMapping("/five/v1")
@RequiredArgsConstructor
public class PostController {

    @Operation(description = "생성요청")
    @PostMapping("/person")
    public ResponseEntity<Person> requestBodyExample(@Parameter(description = "생성요청") @RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(person);
    }
}
