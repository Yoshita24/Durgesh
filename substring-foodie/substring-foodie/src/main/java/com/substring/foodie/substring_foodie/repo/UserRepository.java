package com.substring.foodie.substring_foodie.repo;

import com.substring.foodie.substring_foodie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
