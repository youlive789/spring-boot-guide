package com.spring.guide.guide.nine.order.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.guide.guide.nine.beverage.data.entity.Beverage;
import com.spring.guide.guide.nine.core.BaseEntity;

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
public class BeverageOrdered extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BEVERAGE_ID")
    private Beverage beverage;

    @ManyToOne
    @JoinColumn(name = "ORDERED_ID")
    private Ordered ordered;

    @Column(nullable = false)
    private Long amount;
}
