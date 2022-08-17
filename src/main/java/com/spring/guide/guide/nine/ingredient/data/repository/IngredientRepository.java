package com.spring.guide.guide.nine.ingredient.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.guide.guide.nine.ingredient.data.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>  {
    
}
