package com.spring.guide.guide.twelve.domain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.guide.guide.six.data.dto.ProductResponse;

@FeignClient(value = "example", url = "http://localhost:9999")
public interface ExampleClient {
    
    @GetMapping("/product/v1/1")
    ProductResponse example();
}
