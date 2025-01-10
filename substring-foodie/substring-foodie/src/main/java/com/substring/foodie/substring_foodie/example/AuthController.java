package com.substring.foodie.substring_foodie.example;

import com.substring.foodie.substring_foodie.entity.User;
import com.substring.foodie.substring_foodie.example.payload.UserDTO;
import com.sun.tools.jconsole.JConsoleContext;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    //declare logger
    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    //login
    public void login()
    {

    }
    //sigup
    @PostMapping("/signup")
    public String signup(
            @Valid @RequestBody UserDTO user)
    {
        /* logger of sl4j
        * more control : logging framework : spring boot
        * file
        * console
        * change printing form
        * error
        * debug
        * trace
        * info
        * */
        logger.info("Inside signup name {} {}",user.getName(),35);
        logger.info("Inside signup age {}",user.getAge());

        logger.info("Inside signup email{}",user.getEmail());
        logger.info("Inside signup age {}",user.getAge());

        return "we got data";
    }
}
