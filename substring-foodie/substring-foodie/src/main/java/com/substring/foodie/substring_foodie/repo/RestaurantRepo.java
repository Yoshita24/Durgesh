package com.substring.foodie.substring_foodie.repo;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant,String> {
    List<Restaurant> findByNameContainingIgnoreCase(String name);
    Page<Restaurant> findByOpen(boolean flag, Pageable pageable);
    //check whether if any restaurant current time is between open time and close time
}
