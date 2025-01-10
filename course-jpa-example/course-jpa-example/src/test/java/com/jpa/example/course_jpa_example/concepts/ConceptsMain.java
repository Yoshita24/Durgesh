package com.jpa.example.course_jpa_example.concepts;

import com.jpa.example.course_jpa_example.entities.Laptop;
import com.jpa.example.course_jpa_example.entities.User;
import com.jpa.example.course_jpa_example.repo.LaptopRepository;
import com.jpa.example.course_jpa_example.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ConceptsMain {

    @Autowired
    LaptopRepository laptopRepository;

    @Autowired
    UserRepository userRepository;
    /*@Test
    public void testOnetoOne()
    {
        Optional<User> user = userRepository.findById(152);
        if(user.isPresent())
        {
            Laptop laptop = new Laptop();
            laptop.setAbout("Gaming laptop");
            laptop.setModel("HP");
            laptop.setUser(user.get());
            laptopRepository.save(laptop);
        }else
        {
            System.out.println("User not present");
        }
    }*/
    /*@Test
    public void testGetOneToOne()
    {
        User user = userRepository.findById(152).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("User name : "+user.getName());
        Laptop laptop =user.getLaptop();
        System.out.println("Model : "+laptop.getModel());

    }*/
    /*@Test
    @Transactional
    public void testGetOneToOne1()
    {

        Laptop laptop = laptopRepository.findById(1).orElseThrow(()-> new RuntimeException("Laptop not found"));
        System.out.println("Laptop model : "+laptop.getModel());
        //session jpa closed
        User user = laptop.getUser();
        System.out.println("name :"+user.getName());
    }*/

    @Test
    public void saveOneToMany()
    {
        User user = userRepository.findById(152).orElseThrow(() -> new RuntimeException("user not found"));
        Laptop laptop = new Laptop();
        laptop.setModel("Mac Book");
        laptop.setAbout("This is apple");
        laptop.setUser(user);
        user.getLaptops().add(laptop);
        laptop.setUser(user);
        Laptop laptop1 = new Laptop();
        laptop1.setModel("Lenevo");
        laptop1.setAbout("This is lenevo");
        laptop1.setUser(user);
        user.getLaptops().add(laptop1);
        laptop1.setUser(user);

        userRepository.save(user);


    }
}
