package com.substring.foodie.substring_foodie.example.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Student {
    private String name;
    private int age;
    private List<Subject> subjects;
    private Department department;

}
