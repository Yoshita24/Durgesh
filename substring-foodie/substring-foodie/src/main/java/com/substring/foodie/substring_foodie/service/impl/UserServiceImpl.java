package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.repo.UserRepository;
import com.substring.foodie.substring_foodie.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto saveUser(UserDto userdto) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userdto, String userid) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return List.of();
    }

    @Override
    public List<UserDto> getUserByName(String username) {
        return List.of();
    }

    @Override
    public List<UserDto> getUserByEmail(String email) {
        return List.of();
    }

    @Override
    public UserDto getUserById(String userid) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<UserDto> searchUserName(String keyword) {
        return List.of();
    }

   /* private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        User savedEntity=userRepository.save(user);
        return savedEntity;
    }
@Transactional
    public User updateUser(User user,String userid)
    {
        //org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.substring.foodie.substring_foodie.entity.User.restaurant: could not initialize proxy - no Session
        //above error comes so need to add @Transactional
        Optional<User> fetchedUser = Optional.ofNullable(userRepository.findById(userid).orElseThrow(() -> new RuntimeException("User not found")));
        fetchedUser.get().setName(user.getName());
        //all other fields will get updated


        User save=userRepository.save(fetchedUser.get());
        return save;

    }*/



}
