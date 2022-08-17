package com.spring.guide.guide.nine.ingredient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.guide.guide.nine.ingredient.data.dto.IngredientDto;
import com.spring.guide.guide.nine.ingredient.data.entity.Ingredient;
import com.spring.guide.guide.nine.ingredient.data.repository.IngredientRepository;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.service.impl.IngredientServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTests {
    
    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientServiceImpl;

}
