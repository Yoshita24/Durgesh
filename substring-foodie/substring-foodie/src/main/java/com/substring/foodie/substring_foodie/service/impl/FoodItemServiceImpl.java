package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.FoodItemDto;
import com.substring.foodie.substring_foodie.repo.FoodItemRepo;
import com.substring.foodie.substring_foodie.service.FoodItemService;
import org.springframework.data.domain.Page;

public class FoodItemServiceImpl implements FoodItemService {

    private FoodItemRepo foodItemRepo;

    public FoodItemServiceImpl(FoodItemRepo foodItemRepo) {
        this.foodItemRepo = foodItemRepo;
    }

    @Override
    public FoodItemDto saveFoodItem(FoodItemDto foodItemDto) {
        return null;
    }

    @Override
    public void deleteFoodItem(String id) {

    }

    @Override
    public Page<FoodItemDto> fetchAllFoodItem() {
        return null;
    }

    @Override
    public FoodItemDto updateFoodItem(String id, FoodItemDto foodItemDto) {
        return null;
    }
}
