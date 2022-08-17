package com.spring.guide.guide.nine.ingredient.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.data.entity.Provider;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.service.ProviderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProviderDto createProvider(ProviderDto providerDto) {
        Provider provider = modelMapper.map(providerDto, Provider.class);
        Provider saved = providerRepository.save(provider);
        return modelMapper.map(saved, ProviderDto.class);
    }

    @Override
    public ProviderDto updateProvider(ProviderDto providerDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProviderDto selectProviderById(Long providerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeProviderById(Long providerId) {
        // TODO Auto-generated method stub
        
    }
    
}
