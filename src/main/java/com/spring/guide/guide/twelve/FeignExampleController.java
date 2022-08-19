package com.spring.guide.guide.twelve;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.six.data.dto.ProductResponse;
import com.spring.guide.guide.twelve.domain.ExampleClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FeignExampleController {
    private final ExampleClient exampleClient;

    @GetMapping("/feign/v1/test")
    public ResponseEntity<ProductResponse> test() {
        return ResponseEntity.ok(exampleClient.example());
    }
}
