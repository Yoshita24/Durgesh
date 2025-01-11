package com.substring.foodie.substring_foodie.controller;

import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.Role;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//@Controller
@RequestMapping("/api/v1/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create User
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userdto)
    {
        UserDto userDto = userService.saveUser(userdto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
      //  return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    //get all users
    @GetMapping("/all")
    public ResponseEntity<Page<UserDto>> getAllUsers(
            @RequestParam(value = "page",required = false,defaultValue = "0") int page,
            @RequestParam(value = "size",required = false,defaultValue = "10") int size,
            @RequestParam(value = "sortBy",required = false,defaultValue = "createdDate") String sortBy,
            @RequestParam(value = "sortDir",required = false,defaultValue = "desc") String sortDir
    )
    {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page,size,
                sort);
        Page<UserDto> allUsers = userService.getAll(pageable);
        return new ResponseEntity<>(allUsers,HttpStatus.FOUND);
    }
    //get User by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") String id)
    {
        UserDto userById = userService.getUserById(id);
        return new ResponseEntity<>(userById,HttpStatus.FOUND);
    }
    /*@RequestMapping("/")
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


    }*/
}
