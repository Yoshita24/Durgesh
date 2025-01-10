package org.example;

import org.example.controller.UserController;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!!!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService u=context.getBean("userService", UserService.class);
        u.getService();
        UserController uc=context.getBean("userController", UserController.class);
        uc.callService();

    }
}
