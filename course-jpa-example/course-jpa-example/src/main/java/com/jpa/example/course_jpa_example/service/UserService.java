package com.jpa.example.course_jpa_example.service;

import com.jpa.example.course_jpa_example.entities.User;
import com.jpa.example.course_jpa_example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User get(int userId)
    {
        return userRepository.findById(userId).orElseThrow(
                ()->new RuntimeException("user not found")
        );
    }
}
