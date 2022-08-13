package com.spring.guide.guide.six.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
    private Long stock;
}
