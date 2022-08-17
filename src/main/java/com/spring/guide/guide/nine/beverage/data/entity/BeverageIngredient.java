package com.spring.guide.guide.nine.beverage.data.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.guide.guide.nine.core.BaseEntity;
import com.spring.guide.guide.nine.ingredient.data.entity.Ingredient;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BeverageIngredient extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "BEVERAGE_ID")
    private Beverage beverage;

    @ManyToOne
    @JoinColumn(name = "INGREDIENT_ID")
    private Ingredient ingredient;
}
