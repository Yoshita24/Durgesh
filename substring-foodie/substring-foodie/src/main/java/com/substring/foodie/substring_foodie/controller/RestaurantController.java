package com.substring.foodie.substring_foodie.controller;

import com.substring.foodie.substring_foodie.dto.RestaurantDto;
import com.substring.foodie.substring_foodie.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> saveRestaurant(@RequestBody RestaurantDto restaurantDto)
    {
        RestaurantDto savedRestaurantDto = restaurantService.saveRestaurant(restaurantDto);
        return new ResponseEntity<>(savedRestaurantDto, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<Page<RestaurantDto>> fetchAllRestaurant(
            @RequestParam(value = "page",required = false,defaultValue = "0") int page,
            @RequestParam(value ="size",required = false,defaultValue = "10") int size,
            @RequestParam(value = "sortBy",required = false,defaultValue = "name") String sortBy,
            @RequestParam(value ="sortDir",required = false,defaultValue = "desc") String sortDir
    )
    {

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,
                sort);

        Page<RestaurantDto> restaurantDtoPage= restaurantService.fetchAllRestaurants(pageable);
        return new ResponseEntity<>(restaurantDtoPage,HttpStatus.FOUND);
    }

    @RequestMapping("/deleteRestaurant/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("restaurantId") String id)
    {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>("Restaurant is deleted",HttpStatus.FOUND);
    }
}
