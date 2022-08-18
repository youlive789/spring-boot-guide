package com.spring.guide.guide.nine.Beverage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.guide.guide.nine.beverage.data.dto.BeverageCreateDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageUpdateDto;
import com.spring.guide.guide.nine.beverage.data.entity.Beverage;
import com.spring.guide.guide.nine.beverage.data.repository.BeverageRepository;
import com.spring.guide.guide.nine.beverage.data.type.BeverageType;
import com.spring.guide.guide.nine.beverage.service.impl.BeverageServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BeverageServiceTests {
    @Mock
    private BeverageRepository beverageRepository;

    @InjectMocks
    private BeverageServiceImpl beverageService;

    private Long id = 1L;
    private String name = "americano";
    private Long price = 3L;
    private BeverageType type = BeverageType.COFFEE;
    private List<Long> ingredients;

    private String updateName = "latte";
    private Long updatePrice = 3986L;
    private BeverageType updateType = BeverageType.COCOA;
    private List<Long> updateIngredients;

    private Beverage beverage;
    private Beverage updatedBeverage;
    private BeverageDto beverageDto;
    private BeverageCreateDto beverageCreateDto;
    private BeverageUpdateDto beverageUpdateDto;

    // @BeforeEach
    // void setUp() {
    //     ingredients = new ArrayList<>();
    //     ingredients.add(1L);
    //     ingredients.add(2L);

    //     updateIngredients = new ArrayList<>();
    //     updateIngredients.add(1L);
    //     updateIngredients.add(3L);

    //     beverage = new Beverage(id, name, price, type);
    //     updatedBeverage = new Beverage(id, updateName, updatePrice, updateType);
    //     beverageDto = new BeverageDto(id, name, price, type);
    //     beverageCreateDto = new BeverageCreateDto(name, price, type, ingredients);
    //     beverageUpdateDto = new BeverageUpdateDto(updateName, updatePrice, updateType, updateIngredients);
    // }

    // @Test
    // void createBeverageTest() {
    //     BDDMockito.given(beverageRepository.save(entity)).willReturn();

    //     BeverageDto saved = beverageService.createBeverage(beverageCreateDto);

    //     assertEquals(id, saved.getId());
    //     assertEquals(name, saved.getName());
    //     assertEquals(price, saved.getPrice());
    //     assertEquals(type, saved.getType());
    // }
}
