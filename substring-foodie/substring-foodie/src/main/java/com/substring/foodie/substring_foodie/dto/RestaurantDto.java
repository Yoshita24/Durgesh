package com.substring.foodie.substring_foodie.dto;

import lombok.Data;

import java.time.LocalTime;
@Data
public class RestaurantDto {
    private String id;

    private String name;
    private String address;
   // private LocalTime openTime;

    //private LocalTime closeTime;

    private Boolean isOpen=true;
}
