package com.substring.foodie.substring_foodie.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "FoodItem")
@Data
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal basPrice;
    @Enumerated(EnumType.STRING)
    private UnitType unit;

    private String variationName; // small,1kg
    private BigDecimal weightKg; //for item sold by weight

    private Integer quantity; //for item sold by quantity
    private BigDecimal availableStock; //current stock level

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @CreationTimestamp
    private LocalDateTime createdAt;





}
