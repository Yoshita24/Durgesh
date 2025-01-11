package com.substring.foodie.substring_foodie.example.payload;

import com.substring.foodie.substring_foodie.utils.ValidGender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserDTO {
    @NotEmpty(message = "name is required")
    @Size(min=2,max=20,message = "Name must be between 2 and 20")
    //@Pattern(regexp = "",message = "Invalid username. Username must contain valid username")
    private String name;


    @Min(value = 18,message = "Minimum value required is 18")
    @Max(value = 100,message = "Max value required is 18")
    private int age;

    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "password is required")
    private String password;
    @ValidGender
    private String gender;


    public UserDTO() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
