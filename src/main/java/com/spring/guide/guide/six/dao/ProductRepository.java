package com.spring.guide.guide.six.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.guide.guide.six.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
