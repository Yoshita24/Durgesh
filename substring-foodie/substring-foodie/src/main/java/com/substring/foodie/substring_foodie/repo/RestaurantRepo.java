package com.substring.foodie.substring_foodie.repo;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,String> {

}
