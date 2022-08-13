package com.spring.guide.guide.five;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.five.dto.Person;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "DeleteController")
@RestController
@RequestMapping("/five/v1")
@RequiredArgsConstructor
public class DeleteController {
    
    private final FiveService fiveService;

    @Operation(description = "삭제요청")
    @DeleteMapping("/person")
    public ResponseEntity<Person> deleteExample(@Parameter(description = "삭제 요청할 사람 정보") @RequestBody Person person) {
        log.info("디버그 메세지 확인하기");
        return ResponseEntity.status(HttpStatus.OK).body(fiveService.getSamplePerson());
    }

}
