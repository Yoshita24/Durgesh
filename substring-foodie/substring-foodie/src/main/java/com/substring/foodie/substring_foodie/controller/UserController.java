package com.substring.foodie.substring_foodie.controller;

import com.substring.foodie.substring_foodie.entity.Role;
import com.substring.foodie.substring_foodie.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//@Controller
@RequestMapping("/users")
public class UserController {
    @RequestMapping("/")
   // @ResponseBody
    public String getUser1()
    {
        System.out.println("Inside Users!!!!");
        return "Deven";
    }
    @RequestMapping("/player-list")
    public List<String> players()
    {
        List<String> list = new ArrayList<>();
        list.add("Virat");
        list.add("Rohit");
        list.add("Dhoni");
return list;
    }

    @RequestMapping("/get-user")
    public User getUser()
    {
        User user=new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Deven mahajan");
        user.setEmail("deven@gmail.com");
        user.setAvailable(true);
        user.setAddress("Delhi");
        user.setPassword("abc");
        user.setRoles(Role.ADMIN);
        return user;


    }
}
