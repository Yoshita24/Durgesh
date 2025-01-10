package com.example.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/about")
    public String getData()
    {
        System.out.println("heyyy");
        return "about";
    }
}
