package com.spring.guide.guide.nine.ingredient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.spring.guide.guide.nine.ingredient.data.dto.IngredientDto;
import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.data.entity.Ingredient;
import com.spring.guide.guide.nine.ingredient.data.entity.Provider;
import com.spring.guide.guide.nine.ingredient.data.repository.IngredientRepository;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.data.type.IngredientType;
import com.spring.guide.guide.nine.ingredient.service.impl.IngredientServiceImpl;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTests {
    
    @Mock
    private ModelMapper modelMapper;

    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientServiceImpl;

    private Long id = 1L;
    private String name = "test";
    private IngredientType type = IngredientType.COFFEE_BEAN;
    private Long pricePerGram = 12L;
    
    private Provider provider;
    private Ingredient ingredient;
    private ProviderDto providerDto;
    private IngredientDto ingredientDto;

    @BeforeEach
    void setUpTestData() {
        providerDto = new ProviderDto(id, name);
        provider = Provider.builder()
            .id(id)
            .name(name)
            .build();

        ingredientDto = new IngredientDto(id, name, type, pricePerGram);
        ingredient = Ingredient.builder()
            .id(id)
            .name(name)
            .type(type)
            .pricePerGram(pricePerGram)
            .provider(provider)
            .build();
    }

    @Test
    void selectIngredientByIdTest() {
        BDDMockito.given(ingredientRepository.findById(id)).willReturn(Optional.of(ingredient));
        BDDMockito.given(modelMapper.map(ingredient, IngredientDto.class)).willReturn(ingredientDto);

        IngredientDto found = ingredientServiceImpl.selectIngredientById(id);

        assertEquals(id, found.getId());
        assertEquals(name, found.getName());
    }

    @Test
    void createIngredientTest() {
        BDDMockito.given(modelMapper.map(ingredientDto, Ingredient.class)).willReturn(ingredient);
        BDDMockito.given(modelMapper.map(providerDto, Provider.class)).willReturn(provider);
        BDDMockito.given(ingredientRepository.save(ingredient)).willReturn(ingredient);
        BDDMockito.given(modelMapper.map(ingredient, IngredientDto.class)).willReturn(ingredientDto);

        IngredientDto saved = ingredientServiceImpl.createIngredient(ingredientDto, providerDto);
        
        assertEquals(saved.getId(), id);
        assertEquals(saved.getName(), name);
        assertEquals(saved.getPricePerGram(), pricePerGram);
        assertEquals(saved.getType(), IngredientType.COFFEE_BEAN);
    }

    @Test
    void updateIngredientTest() {
        BDDMockito.given(modelMapper.map(ingredientDto, Ingredient.class)).willReturn(ingredient);
        BDDMockito.given(ingredientRepository.save(ingredient)).willReturn(ingredient);
        BDDMockito.given(modelMapper.map(ingredient, IngredientDto.class)).willReturn(ingredientDto);

        IngredientDto updated = ingredientServiceImpl.updateIngredient(ingredientDto);

        assertEquals(id, updated.getId());
        assertEquals(name, updated.getName());
        assertEquals(pricePerGram, updated.getPricePerGram());
        assertEquals(type, updated.getType());
    }

}
