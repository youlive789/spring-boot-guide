package com.spring.guide.guide.five;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.five.dto.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "GetController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/five/v1/")
public class GetController {

    private final FiveService fiveService;

    @Operation(summary = "pathVariableExample")
    @GetMapping("/person/{name}")
    public ResponseEntity<Person> pathVariableExample(@Parameter(description = "이름 입력") @PathVariable String name) {    
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(fiveService.getNamedPerson(name));
    }

    @Operation(summary = "requestParamExample")
    @GetMapping("/person/request")
    public ResponseEntity<Person> requestParamExample(@Parameter(description = "이름 입력") @RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(fiveService.getNamedPerson(name));
    }
}
