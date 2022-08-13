package com.spring.guide.guide.six;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.guide.guide.six.data.dto.ProductDto;
import com.spring.guide.guide.six.data.dto.ProductResponse;
import com.spring.guide.guide.six.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "ProductController")
@RestController
@RequiredArgsConstructor
@RequestMapping("/product/v1/")
public class ProductController {
    private final ProductService productService;

    @Operation(description = "상품 생성")
    @PostMapping("/create")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductDto product) {
        log.info("productDto : {}", product);
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @Operation(description = "상품 업데이트")
    @PutMapping("/update")
    public ResponseEntity<ProductResponse> update(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @Operation(description = "상품 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody ProductDto product) {
        productService.deleteProduct(product);
        return ResponseEntity.ok("정상 삭제 되었습니다.");
    }

    @Operation(description = "상품 생성 요청")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }
}
