package com.substring.foodie.substring_foodie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "foodie_restaurant")
@Getter
@Setter
public class Restaurant {

    @Id
    private String id;

    private String name;
    @Lob
    private String description;
    private String address;

    private LocalTime openTime;

    private LocalTime closeTime;

    private Boolean open = true;

    private LocalDateTime createdDate;
    private String banner;
    @ManyToOne
    private User user;
}
