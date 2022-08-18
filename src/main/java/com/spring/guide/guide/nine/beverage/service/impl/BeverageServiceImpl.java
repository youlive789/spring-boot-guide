package com.spring.guide.guide.nine.beverage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.guide.guide.nine.beverage.data.dto.BeverageCreateDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageUpdateDto;
import com.spring.guide.guide.nine.beverage.data.entity.Beverage;
import com.spring.guide.guide.nine.beverage.data.entity.BeverageIngredient;
import com.spring.guide.guide.nine.beverage.data.repository.BeverageIngredientRepository;
import com.spring.guide.guide.nine.beverage.data.repository.BeverageRepository;
import com.spring.guide.guide.nine.beverage.service.BeverageService;
import com.spring.guide.guide.nine.ingredient.data.entity.Ingredient;
import com.spring.guide.guide.nine.ingredient.data.repository.IngredientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService  {
    private final ModelMapper modelMapper;
    private final BeverageRepository beverageRepository;
    private final IngredientRepository ingredientRepository;
    private final BeverageIngredientRepository beverageIngredientRepository;

    @Override
    @Transactional
    public BeverageDto createBeverage(BeverageCreateDto beverage) {
        Beverage saveEntity = modelMapper.map(beverage, Beverage.class);
        Beverage saved = beverageRepository.save(saveEntity);

        saveBeverageIngredients(saved, beverage.getIngredients());

        return modelMapper.map(saved, BeverageDto.class);
    }

    private void saveBeverageIngredients(Beverage saved, List<Long> ingredientIds) {
        List<BeverageIngredient> beverageIngredients = new ArrayList<>();
        for (Long ingredientId : ingredientIds) {
            Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(IllegalArgumentException::new);
            BeverageIngredient beverageIngredientEntity = new BeverageIngredient(null, saved, ingredient);
            beverageIngredients.add(beverageIngredientEntity);
        }
        beverageIngredientRepository.saveAll(beverageIngredients);
    }

    @Override
    @Transactional
    public BeverageDto updateBeverage(BeverageUpdateDto beverage) {
        Beverage updateEntity = modelMapper.map(beverage, Beverage.class);
        Beverage updated = beverageRepository.save(updateEntity);

        deleteBeverageIngredients(updated);
        saveBeverageIngredients(updated, beverage.getIngredients());

        return modelMapper.map(updated, BeverageDto.class);
    }

    private void deleteBeverageIngredients(Beverage updated) {
        beverageIngredientRepository.deleteAllByBeverageId(updated.getId());
    }

    @Override
    public BeverageDto selectBeverage(Long id) {
        Beverage found = beverageRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(found, BeverageDto.class);
    }

    @Override
    @Transactional
    public void removeBeverage(Long id) {
        Beverage found = beverageRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        deleteBeverageIngredients(found);
        beverageRepository.delete(found);
    }
}
