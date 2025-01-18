package com.substring.foodie.substring_foodie.repo;

import com.substring.foodie.substring_foodie.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepo extends JpaRepository<FoodItem,Long> {
}
