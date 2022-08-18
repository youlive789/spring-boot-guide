package com.spring.guide.guide.nine.beverage.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.guide.guide.nine.beverage.data.entity.Beverage;

public interface BeverageRepository extends CrudRepository<Beverage, Long> {
    
}
