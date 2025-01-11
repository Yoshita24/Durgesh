package com.substring.foodie.substring_foodie.repo;

import com.substring.foodie.substring_foodie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    List<User> findByName(String name);
    List<User> findByEmail(String email);

}
