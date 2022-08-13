package com.spring.guide.guide.six.service;

import com.spring.guide.guide.six.data.dto.ProductDto;
import com.spring.guide.guide.six.data.dto.ProductResponse;

public interface ProductService {
    public ProductResponse getProduct(Long id);
    public ProductResponse createProduct(ProductDto product);
    public ProductResponse updateProduct(ProductDto product);
    public void deleteProduct(ProductDto product);
}
