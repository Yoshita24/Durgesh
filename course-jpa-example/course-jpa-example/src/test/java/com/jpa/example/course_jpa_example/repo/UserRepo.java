package com.jpa.example.course_jpa_example.repo;

import com.jpa.example.course_jpa_example.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepo {

    @Autowired
    UserRepository  userRepository;

    @Test
    public void repoTest()
    {
       boolean user= userRepository.existsByEmail("yoshita@gmail.com");
       System.out.println("Exists :"+user);
    }
    @Test
    public void repoTest2()
    {
        List<User> cities = userRepository.getUsersByCity("Mumbai");
        System.out.println(cities);
    }
}
