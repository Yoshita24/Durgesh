package com.substring.foodie.substring_foodie.service.impl;

import com.substring.foodie.substring_foodie.dto.UserDto;
import com.substring.foodie.substring_foodie.entity.Restaurant;
import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.exception.ResourceNotFoundException;
import com.substring.foodie.substring_foodie.repo.UserRepository;
import com.substring.foodie.substring_foodie.service.UserService;
import com.substring.foodie.substring_foodie.utils.Helper;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDto saveUser(UserDto userdto) {
        userdto.setId(Helper.generateRandomId());
        User savedUser = userRepository.save(convertUserDtoToUser(userdto));
        return convertUserToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userdto, String userid) {
        return null;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);

        return userPage.map(user -> convertUserToUserDto(user));
    }


    @Override
    public List<UserDto> getUserByName(String username) {
        List<User> byNamelist = userRepository.findByName(username);
        List<UserDto> list = byNamelist.stream().map(user -> convertUserToUserDto(user)).toList();
        return list;
    }

    @Override
    public List<UserDto> getUserByEmail(String email) {
        List<User> byEmailList = userRepository.findByEmail(email);
        List<UserDto> list = byEmailList.stream().map(user -> convertUserToUserDto(user)).toList();
        return list;
    }

    @Override
    public UserDto getUserById(String userid) {
       User user= userRepository.findById(userid).orElseThrow(()-> new ResourceNotFoundException("user not found"));
        return convertUserToUserDto(user);
    }

    @Override
    public void deleteUser(String userId) {
            userRepository.deleteById(userId);
    }

    @Override
    public List<UserDto> searchUserName(String userName) {
        return List.of();
    }

    private User convertUserDtoToUser(UserDto userDto)
    {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setAddress(userDto.getAddress());
        return user;
    }

    private UserDto convertUserToUserDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
    /*private User convertUserDtoToUser(UserDto userDto)
    {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }*/

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
