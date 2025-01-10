package com.substring.foodie.substring_foodie.example.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String name;
    private int age;
    private String email;
    private String password;

    public UserDTO() {
    }
}
