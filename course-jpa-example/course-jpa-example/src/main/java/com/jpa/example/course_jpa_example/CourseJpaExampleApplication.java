package com.jpa.example.course_jpa_example;

import com.jpa.example.course_jpa_example.entities.Laptop;
import com.jpa.example.course_jpa_example.entities.User;
import com.jpa.example.course_jpa_example.repo.LaptopRepository;
import com.jpa.example.course_jpa_example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseJpaExampleApplication  implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	LaptopRepository laptopRepository;
	public static void main(String[] args) {
		SpringApplication.run(CourseJpaExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User user = new User();
		user.setName("Deven");
		user.setAge("20");
		user.setActiveUser(true);
		user.setEmail("deven@gmail.com");
		userRepository.save(user);*/


	}
}
