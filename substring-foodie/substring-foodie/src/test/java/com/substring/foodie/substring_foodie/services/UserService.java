package com.substring.foodie.substring_foodie.services;

import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.Role;
import com.substring.foodie.substring_foodie.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class UserService {

    @Autowired
    private com.substring.foodie.substring_foodie.service.UserService userService;
   /* @Test
    public void testSaveUser()
    {
        System.out.println("Saving user....");
        User user=new User();
        user.setName("Deven mahajan");
        user.setEmail("deven@gmail.com");
        user.setAvailable(true);
        user.setAddress("Delhi");
        user.setPassword("abc");
        user.setRoles(Role.ADMIN);

        Restaurant restaurant = new Restaurant();
        restaurant.setId(UUID.randomUUID().toString());
        restaurant.setName("KFC");
        restaurant.setAddress("Lucknow");
        restaurant.setIsOpen(true);

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(UUID.randomUUID().toString());
        restaurant1.setName("Haldiram");
        restaurant1.setAddress("Lucknow");
        restaurant1.setIsOpen(true);

        restaurant.setUser(user);
        restaurant1.setUser(user);

        user.getRestaurant().add(restaurant);
        user.getRestaurant().add(restaurant1);

        userService.saveUser(user);

    }*/
/*@Test
    public void testupdateUser()
    {
    userService.updateUser();
    System.out.println("User updated");
    }*/


}
