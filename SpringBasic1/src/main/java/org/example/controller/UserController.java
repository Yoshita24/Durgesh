package org.example.controller;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    /*below is used when constructor is being used*/
    /*public UserController(UserService userService) {
        System.out.println("Inside UserController constructor");
        this.userService = userService;
    }*/

   /*
    below is with propery refer for which setter is required in class

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/


    public void callService() {
        System.out.println("Inside callService..");
        userService.getService();
    }


}
