package com.spring.guide.guide.six.dao;

import com.spring.guide.guide.six.data.entity.Product;

public interface ProductDao {
    public Product selectProduct(Long id);
    public Product insertProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(Product product);
}
