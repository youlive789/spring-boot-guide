package com.spring.guide.guide.nine.ingredient.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.spring.guide.guide.nine.ingredient.data.dto.ProviderDto;
import com.spring.guide.guide.nine.ingredient.data.entity.Provider;
import com.spring.guide.guide.nine.ingredient.data.repository.ProviderRepository;
import com.spring.guide.guide.nine.ingredient.service.impl.ProviderServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProviderServiceTests {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ProviderRepository providerRepository;

    @InjectMocks
    private ProviderServiceImpl providerService;

    @Test
    void createProviderTest() {
        Long providerId = 1L;
        String providerName = "tester";

        Provider provider = Provider.builder()
            .id(providerId)
            .name(providerName)
            .build();
        ProviderDto providerDto = new ProviderDto(providerId, providerName);

        BDDMockito.given(modelMapper.map(providerDto, Provider.class)).willReturn(provider);
        BDDMockito.given(modelMapper.map(provider, ProviderDto.class)).willReturn(providerDto);
        BDDMockito.given(providerRepository.save(provider)).willReturn(provider);

        ProviderDto saved = providerService.createProvider(providerDto);

        assertEquals(providerId, saved.getId());
        assertEquals(providerName, saved.getName());
    }

    @Test
    void updateProviderTest() {
        Long providerId = 1L;
        String providerOriginName = "tester";
        String providerUpdatedName = "tester1";

        ProviderDto originDto = new ProviderDto(providerId, providerOriginName);
        Provider originProvider = Provider.builder()
            .id(providerId)
            .name(providerOriginName)
            .createAt(Date.valueOf(LocalDate.now()))
            .updatedAt(Date.valueOf(LocalDate.now()))
            .build();

        BDDMockito.given(modelMapper.map(originDto, Provider.class)).willReturn(originProvider);
        BDDMockito.given(modelMapper.map(originProvider, ProviderDto.class)).willReturn(originDto);
        BDDMockito.given(providerRepository.save(originProvider)).willReturn(originProvider);
        providerService.createProvider(originDto);
        
        ProviderDto updateDto = new ProviderDto(providerId, providerUpdatedName);
        Provider updateProvider = Provider.builder()
            .id(providerId)
            .name(providerUpdatedName)
            .createAt(Date.valueOf(LocalDate.now()))
            .updatedAt(Date.valueOf(LocalDate.now()))
            .build();

        BDDMockito.given(modelMapper.map(updateDto, Provider.class)).willReturn(updateProvider);
        BDDMockito.given(modelMapper.map(updateProvider, ProviderDto.class)).willReturn(updateDto);
        BDDMockito.given(providerRepository.save(updateProvider)).willReturn(updateProvider);
        ProviderDto updated = providerService.updateProvider(updateDto);

        assertEquals(providerId, updated.getId());
        assertEquals(providerUpdatedName, updated.getName());
        assertNotEquals(providerOriginName, updated.getName());
    }

    @Test
    void selectProviderByIdTest() {
        Long providerId = 1L;
        String name = "tester";

        ProviderDto providerDto = new ProviderDto(providerId, name);
        Provider provider = Provider.builder()
            .id(providerId)
            .name(name)
            .createAt(Date.valueOf(LocalDate.now()))
            .updatedAt(Date.valueOf(LocalDate.now()))
            .build();

        BDDMockito.given(modelMapper.map(provider, ProviderDto.class)).willReturn(providerDto);
        BDDMockito.given(providerRepository.findById(providerId)).willReturn(Optional.of(provider));
        ProviderDto found = providerService.selectProviderById(providerId);

        assertEquals(providerId, found.getId());
        assertEquals(name, found.getName());
    }
}
