package com.spring.guide.guide.nine.beverage.service;

import com.spring.guide.guide.nine.beverage.data.dto.BeverageCreateDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageDto;
import com.spring.guide.guide.nine.beverage.data.dto.BeverageUpdateDto;

public interface BeverageService {
    public BeverageDto createBeverage(BeverageCreateDto beverage);
    public BeverageDto updateBeverage(BeverageUpdateDto beverage);
    public BeverageDto selectBeverage(Long id);
    public void removeBeverage(Long id);
}
