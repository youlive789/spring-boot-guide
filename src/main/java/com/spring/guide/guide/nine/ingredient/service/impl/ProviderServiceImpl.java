package com.spring.guide.guide.nine.ingredient.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.data.entity.Provider;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.service.ProviderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ModelMapper modelMapper;
    private final ProviderRepository providerRepository;

    @Override
    public ProviderDto createProvider(ProviderDto providerDto) {
        Provider provider = modelMapper.map(providerDto, Provider.class);
        Provider saved = providerRepository.save(provider);
        return modelMapper.map(saved, ProviderDto.class);
    }

    @Override
    public ProviderDto updateProvider(ProviderDto providerDto) {
        Provider provider = modelMapper.map(providerDto, Provider.class);
        Provider saved = providerRepository.save(provider);
        return modelMapper.map(saved, ProviderDto.class);
    }

    @Override
    public ProviderDto selectProviderById(Long providerId) {
        Provider found = providerRepository.findById(providerId).orElse(null);
        return modelMapper.map(found, ProviderDto.class);
    }

    @Override
    public void removeProviderById(Long providerId) {
        providerRepository.deleteById(providerId);
    }
    
}
