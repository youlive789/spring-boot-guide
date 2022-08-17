package com.spring.guide.guide.nine.ingredient.service;

import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;

public interface ProviderService {
    public ProviderDto createProvider(ProviderDto providerDto);
    public ProviderDto updateProvider(ProviderDto providerDto);
    public ProviderDto selectProviderById(Long providerId);
    public void removeProviderById(Long providerId);
}
