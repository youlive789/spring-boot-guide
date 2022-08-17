package com.spring.guide.guide.nine.ingredient.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.guide.guide.nine.core.BaseEntity;
import com.spring.guide.guide.nine.ingredient.data.type.IngredientType;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class Ingredient extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INGREDIENT_ID", nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @Column(nullable = false)
    private Long pricePerGram;

    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    @ToString.Exclude
    private Provider provider;
}
