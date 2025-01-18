package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.dto.FoodItemDto;
import org.springframework.data.domain.Page;

public interface FoodItemService {
    //crud
    public FoodItemDto saveFoodItem(FoodItemDto foodItemDto);
    public void deleteFoodItem(String id);
    public Page<FoodItemDto> fetchAllFoodItem();
    public FoodItemDto updateFoodItem(String id, FoodItemDto foodItemDto);
}
