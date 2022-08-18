package com.spring.guide.guide.nine.beverage.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.guide.guide.nine.beverage.data.entity.BeverageIngredient;

public interface BeverageIngredientRepository extends CrudRepository<BeverageIngredient, Long> {
    void deleteAllByBeverageId(Long beverageId);
}
