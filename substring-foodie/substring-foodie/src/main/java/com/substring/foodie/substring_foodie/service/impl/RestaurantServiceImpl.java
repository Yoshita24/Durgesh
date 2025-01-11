package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.repo.RestaurantRepo;
import com.substring.foodie.substring_foodie.service.RestaurantService;
import com.substring.foodie.substring_foodie.utils.Helper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepo restaurantRepo;

    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        restaurantDto.setId(Helper.generateRandomId());
        Restaurant savedRestaurant= restaurantRepo.save(convertRestaurantDtoToRestaurant(restaurantDto));
        return convertRestaurantToRestaurantDto(savedRestaurant);
    }

    @Override
    public Page<RestaurantDto> fetchAllRestaurants(Pageable pageable) {
        Page<Restaurant> restaurantPage = restaurantRepo.findAll(pageable);
        return restaurantPage.map(restaurant -> convertRestaurantToRestaurantDto(restaurant));
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto, String restaurantId) {
        return null;
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
         restaurantRepo.deleteById(restaurantId);

    }

    private RestaurantDto convertRestaurantToRestaurantDto(Restaurant restaurant)
    {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setAddress(restaurant.getAddress());
        //restaurantDto.setCloseTime(restaurant.getCloseTime());
        restaurantDto.setIsOpen(restaurant.getIsOpen());
       // restaurantDto.setOpenTime(restaurant.getOpenTime());

        return restaurantDto;
    }
    private Restaurant convertRestaurantDtoToRestaurant(RestaurantDto restaurantDto)
    {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
       // restaurant.setCloseTime(restaurantDto.getCloseTime());
        restaurant.setIsOpen(restaurantDto.getIsOpen());
        //restaurant.setOpenTime(restaurantDto.getOpenTime());
        return restaurant;
    }
}
