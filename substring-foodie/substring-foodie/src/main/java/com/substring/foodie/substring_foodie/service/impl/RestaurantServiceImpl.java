package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.exception.ResourceNotFoundException;
import com.substring.foodie.substring_foodie.repo.RestaurantRepo;
import com.substring.foodie.substring_foodie.service.RestaurantService;
import com.substring.foodie.substring_foodie.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepo restaurantRepo;

    private ModelMapper modelMapper;

    public RestaurantServiceImpl(RestaurantRepo restaurantRepo, ModelMapper modelMapper) {
        this.restaurantRepo = restaurantRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
        restaurantDto.setId(Helper.generateRandomId());
        restaurantDto.setCreatedDate(LocalDateTime.now());
      Restaurant restaurant=  modelMapper.map(restaurantDto,Restaurant.class);
        //Restaurant savedRestaurant= restaurantRepo.save(convertRestaurantDtoToRestaurant(restaurantDto));
        Restaurant savedRestaurant= restaurantRepo.save(restaurant);
       // return convertRestaurantToRestaurantDto(savedRestaurant);
        return modelMapper.map(savedRestaurant,RestaurantDto.class);
    }

    @Override
    public Page<RestaurantDto> fetchAllRestaurants(Pageable pageable) {
        Page<Restaurant> restaurantPage = restaurantRepo.findAll(pageable);
        return restaurantPage.map(restaurant -> modelMapper.map(restaurant,RestaurantDto.class));
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto, String restaurantId) {
        Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(()->new ResourceNotFoundException("Restaurant not found"));
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
      Restaurant restaurant1=  restaurantRepo.save(restaurant);
        return convertRestaurantToRestaurantDto(restaurant1);
    }

    @Override
    public void deleteRestaurant(String restaurantId) {
         restaurantRepo.deleteById(restaurantId);

    }

    @Override
    public RestaurantDto fetchRestaurant(String id) {
        Restaurant restaurant = restaurantRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Restaurant not found"));

        return modelMapper.map(restaurant,RestaurantDto.class);
    }

    @Override
    public List<RestaurantDto> searchByName(String keyword) {
        return restaurantRepo.findByNameContainingIgnoreCase(keyword).stream()
                .map(restaurant -> modelMapper.map(restaurant,RestaurantDto.class)).toList();
    }

    @Override
    public Page<RestaurantDto> getOpenRestaurants(Pageable pageable) {

        Page<Restaurant> restaurantPage = restaurantRepo.findByOpen(true,pageable);
        return restaurantPage.map(restaurant -> modelMapper.map(restaurant,RestaurantDto.class));
    }

    private RestaurantDto convertRestaurantToRestaurantDto(Restaurant restaurant)
    {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setAddress(restaurant.getAddress());
        //restaurantDto.setCloseTime(restaurant.getCloseTime());
        restaurantDto.setOpen(restaurant.getOpen());
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
        restaurant.setOpen(restaurantDto.getOpen());
        //restaurant.setOpenTime(restaurantDto.getOpenTime());
        return restaurant;
    }
}
