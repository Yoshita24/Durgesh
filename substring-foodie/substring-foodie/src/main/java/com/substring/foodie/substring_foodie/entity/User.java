package com.substring.foodie.substring_foodie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="foodie_users")
@Getter
@Setter
public class User {


    @Id
    private String id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role roles; //ADMIN,CUSTOMER,DELIVERY_BOY

    private boolean isAvailable=true; //applicable for delivery boy

    private LocalDate createdDate;
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


}
