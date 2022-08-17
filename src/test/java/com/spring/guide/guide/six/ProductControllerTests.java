package com.spring.guide.guide.six;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.spring.guide.guide.six.data.dto.ProductResponse;
import com.spring.guide.guide.six.service.impl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTests {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    ProductServiceImpl productService;

    @Test
    @DisplayName("상품 조회 API 테스트")
    void getProductTest() throws Exception {

        Long productId = 123L;
        String productName = "test";

        // given
        given(productService.getProduct(productId)).willReturn(new ProductResponse(productId, productName));

        // when
        mvc.perform(get("/product/v1/" + productId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.name").exists())
            .andDo(print());

        // then
        verify(productService).getProduct(productId);
    }

}
