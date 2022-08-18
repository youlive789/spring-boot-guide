package com.spring.guide.guide.nine.ingredient.data.dto;

import com.spring.guide.guide.nine.ingredient.data.type.IngredientType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private Long id;
    private String name;
    private IngredientType type;
    private Long pricePerGram;
}
