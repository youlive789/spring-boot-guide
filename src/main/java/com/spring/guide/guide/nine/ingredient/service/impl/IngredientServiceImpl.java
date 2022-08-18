package com.spring.guide.guide.nine.ingredient.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.guide.guide.nine.ingredient.data.dto.IngredientDto;
import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.data.entity.Ingredient;
import com.spring.guide.guide.nine.ingredient.data.entity.Provider;
import com.spring.guide.guide.nine.ingredient.data.repository.IngredientRepository;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.service.IngredientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final ModelMapper modelMapper;
    private final IngredientRepository ingredientRepository;
    private final ProviderRepository providerRepository;

    @Override
    public IngredientDto selectIngredientById(Long ingredientId) {
        Ingredient found = ingredientRepository.findById(ingredientId).orElse(null);
        return modelMapper.map(found, IngredientDto.class);
    }

    @Override
    public IngredientDto createIngredient(IngredientDto ingredient, ProviderDto provider) {
        Provider providerEntity = providerRepository.findById(provider.getId()).orElse(modelMapper.map(provider, Provider.class));
        Ingredient ingredientEntity = modelMapper.map(ingredient, Ingredient.class);
        ingredientEntity.setProvider(providerEntity);

        Ingredient saved = ingredientRepository.save(ingredientEntity);
        return modelMapper.map(saved, IngredientDto.class);
    }

    @Override
    public IngredientDto updateIngredient(IngredientDto ingredient) {
        Ingredient ingredientEntity = ingredientRepository.findById(ingredient.getId()).orElseThrow(IllegalArgumentException::new);
        ingredientEntity.setName(ingredient.getName());
        ingredientEntity.setPricePerGram(ingredient.getPricePerGram());
        ingredientEntity.setType(ingredient.getType());

        Ingredient saved = ingredientRepository.save(ingredientEntity);
        return modelMapper.map(saved, IngredientDto.class);
    }

    @Override
    public void removeIngredient(Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }
    
}
