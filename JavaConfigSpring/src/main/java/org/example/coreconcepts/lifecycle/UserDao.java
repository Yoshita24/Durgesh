package org.example.coreconcepts.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

//@Component
public class UserDao  {

   String connection = null;
    public void saveUser()
    {
        System.out.println("Inside saveUser connection length : " + connection.length());
        System.out.println("Save data to db");

    }

    public void printUser()
    {
        System.out.println("Inside printUser connection length : " + connection.length());
        System.out.println("Save data to db");

    }

    @PreDestroy
    public void destroy() throws Exception {
        connection = null;
        System.out.println("Destroy Properties");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        connection="1234";
    }
}
