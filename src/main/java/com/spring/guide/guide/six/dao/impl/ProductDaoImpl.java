package com.spring.guide.guide.six.dao.impl;

import org.springframework.stereotype.Component;

import com.spring.guide.guide.six.dao.ProductDao;
import com.spring.guide.guide.six.dao.ProductRepository;
import com.spring.guide.guide.six.data.entity.Product;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository repository;

    @Override
    public Product selectProduct(Long id) {
        return repository.findById(id).orElseGet(Product::new);
    }

    @Override
    public Product insertProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }
    
}
