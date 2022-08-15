package com.spring.guide.guide.six.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.guide.guide.six.dao.ProductDao;
import com.spring.guide.guide.six.data.dto.ProductDto;
import com.spring.guide.guide.six.data.dto.ProductResponse;
import com.spring.guide.guide.six.data.entity.Product;
import com.spring.guide.guide.six.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse getProduct(Long id) {
        return modelMapper.map(productDao.selectProduct(id), ProductResponse.class);
    }

    @Override
    public ProductResponse createProduct(ProductDto product) {
        Product entity = modelMapper.map(product, Product.class);
        return modelMapper.map(productDao.insertProduct(entity), ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(ProductDto product) {
        Product entity = modelMapper.map(product, Product.class);
        return modelMapper.map(productDao.updateProduct(entity), ProductResponse.class);
    }

    @Override
    public void deleteProduct(ProductDto product) {
        Product entity = modelMapper.map(product, Product.class);
        productDao.deleteProduct(entity);
    }
    
}
