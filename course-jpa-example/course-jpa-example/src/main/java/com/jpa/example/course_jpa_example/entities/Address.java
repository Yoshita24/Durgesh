package com.jpa.example.course_jpa_example.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String state;
    private String city;
    private String pincode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
