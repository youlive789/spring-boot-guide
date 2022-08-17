package com.spring.guide.guide.nine.ingredient.service.impl;

import org.springframework.stereotype.Service;

import com.spring.guide.guide.nine.ingredient.data.dto.IngredientDto;
import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.data.repository.IngredientRepository;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.service.IngredientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final ProviderRepository providerRepository;

    @Override
    public IngredientDto selectIngredientById(Long ingredientId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IngredientDto createIngredient(IngredientDto ingredient, ProviderDto provider) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IngredientDto updateIngredient(IngredientDto ingredient) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeIngredient(Long ingredientId) {
        // TODO Auto-generated method stub
        
    }
    
}
