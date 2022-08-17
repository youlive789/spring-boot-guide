package com.spring.guide.guide.nine.ingredient.service;

import com.spring.guide.guide.nine.ingredient.data.dto.IngredientDto;
import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;

public interface IngredientService {
    public IngredientDto selectIngredientById(Long ingredientId);
    public IngredientDto createIngredient(IngredientDto ingredient, ProviderDto provider);
    public IngredientDto updateIngredient(IngredientDto ingredient);
    public void removeIngredient(Long ingredientId);
}
