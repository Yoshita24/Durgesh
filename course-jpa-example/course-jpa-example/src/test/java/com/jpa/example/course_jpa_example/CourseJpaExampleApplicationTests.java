package com.jpa.example.course_jpa_example;

import com.jpa.example.course_jpa_example.dto.UserType;
import com.jpa.example.course_jpa_example.entities.Address;
import com.jpa.example.course_jpa_example.entities.User;
import com.jpa.example.course_jpa_example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseJpaExampleApplicationTests {

	@Autowired
	UserService userService;
	@Test
	public void testUser()
	{
		User user = new User();
		user.setName("Yoshita");
		user.setAge("10");
		user.setActiveUser(true);
		user.setEmail("yoshita@gmail.com");
		user.setType(UserType.HOD);
		Address address = new Address();
		address.setCity("Mumbai");
		address.setPincode("400086");
		address.setState("Maharashtra");
		user.setAddress(address);
		userService.save(user);

	}
@Test
	public void getTestuser()
	{
		User user= userService.get(0);
		System.out.println("Name : "+user.getName());
	}


}
