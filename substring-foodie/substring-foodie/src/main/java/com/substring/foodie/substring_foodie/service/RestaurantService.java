package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {
    RestaurantDto saveRestaurant(RestaurantDto restaurantDto);
    Page<RestaurantDto> fetchAllRestaurants(Pageable    pageable);
    RestaurantDto updateRestaurant(RestaurantDto restaurantDto,String restaurantId);
    void deleteRestaurant(String restaurantId);

}
