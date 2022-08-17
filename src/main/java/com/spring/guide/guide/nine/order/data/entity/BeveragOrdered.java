package com.spring.guide.guide.nine.order.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.guide.guide.nine.beverage.data.entity.Beverage;
import com.spring.guide.guide.nine.core.BaseEntity;

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
public class BeveragOrdered extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "BEVERAGE_ID")
    private Beverage beverage;

    @ManyToOne
    @JoinColumn(name = "ORDERED_ID")
    private Ordered ordered;

    @Column(nullable = false)
    private Long amount;
}
