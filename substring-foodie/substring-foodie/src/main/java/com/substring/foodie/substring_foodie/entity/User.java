package com.substring.foodie.substring_foodie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="foodie_users")

public class User {

    @Getter
    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role roles; //ADMIN,CUSTOMER,DELIVERY_BOY

    private boolean isAvailable=true; //applicable for delivery boy


    //@OneToMany(mappedBy = "user",cascade = CascadeType.ALL) //so here new field wont be created in user table.. this mapping would be handled by restaurant table itself with user field
    //mapped == field to handler mapping
    //cascade = if parent change then what impact on child
    //so if CascadeType.ALL then what all operations performed on parent all would be done on child
    //here parent is user and child is restaurant

    //fetch - bydefault its eager(1 to 1)
    //fetch - bydefault its lazy(1 to many)

    //orphanremoval = true
    //this means that if user deven has 5 restaurant with him n he removed 2 from restraurant list using java collection
    // and then he saves to user repo .. then those 2 restaurant would become orphan that is no linkage
    // so then those 2 restaurant would also get removed from db when we do orphanremoval = true
   // private List<Restaurant> restaurant = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
