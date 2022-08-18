package com.spring.guide.guide.nine.ingredient.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class IngredientCreateRequest {
    private IngredientDto ingredient;
    private ProviderDto provider;
}
