package com.spring.guide.guide.nine.beverage.data.dto;

import java.util.List;

import com.spring.guide.guide.nine.beverage.data.type.BeverageType;

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
public class BeverageCreateDto {
    private String name;
    private Long price;
    private BeverageType type;
    private List<Long> ingredients;
}
