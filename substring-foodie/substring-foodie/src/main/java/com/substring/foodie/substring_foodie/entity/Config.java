package com.substring.foodie.substring_foodie.entity;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
