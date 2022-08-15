package com.spring.guide.guide.six.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.spring.guide.guide.six.dao.impl.ProductDaoImpl;
import com.spring.guide.guide.six.data.dto.ProductResponse;
import com.spring.guide.guide.six.data.entity.Product;
import com.spring.guide.guide.six.service.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductDaoImpl productDao;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProductServiceImpl productService; 

    @Test
    @DisplayName("상품 조회 서비스 테스트")
    void getProductTest() {
        // 데이터를 직접 주입해서 테스트를 하다보면 테스트 케이스가 추후 깨질 수도 있다.
        // 더 좋은 방법을 계속해서 고민해보자.

        // given
        Long productId = 123L;
        String productName = "test";

        BDDMockito.given(productDao.selectProduct(productId))
            .willReturn(new Product(productId, productName, null, null, null, null));

        BDDMockito.given(modelMapper.map(productDao.selectProduct(productId), ProductResponse.class))
            .willReturn(new ProductResponse(productId, productName));

        // when
        ProductResponse productResponse = productService.getProduct(productId);

        // then
        assertEquals(productId, productResponse.getId());
        assertEquals(productName, productResponse.getName());
    }

}
