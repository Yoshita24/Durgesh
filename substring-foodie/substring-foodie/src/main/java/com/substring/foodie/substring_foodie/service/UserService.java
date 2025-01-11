package com.substring.foodie.substring_foodie.service;

import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.example.payload.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userdto);
    UserDto updateUser(UserDto userdto,String userid);
    List<UserDto> getAll();
    List<UserDto> getUserByName(String username);
    List<UserDto> getUserByEmail(String email);
    UserDto getUserById(String userid);
    void deleteUser(String userId);
    List<UserDto> searchUserName(String keyword);

}
