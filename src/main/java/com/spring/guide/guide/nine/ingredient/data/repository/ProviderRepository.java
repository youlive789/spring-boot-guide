package com.spring.guide.guide.nine.ingredient.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.guide.guide.nine.ingredient.data.entity.Provider;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
    
}
