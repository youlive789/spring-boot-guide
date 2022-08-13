package com.spring.guide.guide.five;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.five.dto.Person;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "PutController")
@RestController
@RequestMapping("/five/v1")
@RequiredArgsConstructor
public class PutController {

    private final FiveService fiveService;

    @PutMapping("/person")
    public ResponseEntity<Person> putExample(@Parameter(description = "변경할 사람 정보") @RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(fiveService.getSamplePerson());
    }
}
