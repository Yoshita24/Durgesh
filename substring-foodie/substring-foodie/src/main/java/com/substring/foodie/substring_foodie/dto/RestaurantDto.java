package com.substring.foodie.substring_foodie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
public class RestaurantDto {
    private String id;

    private String name;
    private String address;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss a")
   private LocalTime openTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss a")
    private LocalTime closeTime;

    private Boolean open=true;
    @JsonIgnore
    private String banner;
    @JsonProperty //in response while sending to client it will be send
    private String getImageUrl()
    {
        return "http://localhost:8080/images/test";
    }
    private String description;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String status="restaurant testing";

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy hh:mm:ss a")
  //  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDateTime createdDate;
}
