package com.course.management.course_spring_jdbc_example;

import com.course.management.course_spring_jdbc_example.dao.CategoryDao;
import com.course.management.course_spring_jdbc_example.dao.CourseDao;
import com.course.management.course_spring_jdbc_example.entities.Category;
import com.course.management.course_spring_jdbc_example.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@SpringBootApplication
public class CourseSpringJdbcExampleApplication implements CommandLineRunner {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CourseDao courseDao;
	public static void main(String[] args) {
		SpringApplication.run(CourseSpringJdbcExampleApplication.class, args);

		//if no db related config not added then below error ll come
		//Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
		/*try {
			String url = "jdbc:mysql://localhost:3306/jb2404";
			String user = "root";
			String password = "mysql@123";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started ");
		Course course = new Course();
		course.setId(501);
		course.setTitle("hardware");
		course.setDescription("This is hardware course");
		course.setCategoryId(101);
		Course createdCourse = courseDao.createCourse(course);
		System.out.println(createdCourse);
		System.out.println("*******");
		Course updateCourse = new Course();
		updateCourse.setId(501);
		updateCourse.setTitle("software");
		updateCourse.setDescription("This is software course");
		courseDao.update(updateCourse);
		System.out.println("*******");
		System.out.println(courseDao.getCourse(501));
		System.out.println("*******");
		courseDao.deleteCouse(501);
		System.out.println(courseDao.getAllCourse());
		System.out.println("*******");
		System.out.println(courseDao.getCourseCategoryJoinData());
	}

	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started");
		Category category = new Category();
		category.setId(110);
		category.setTitle("Trending");
		category.setDescription("This is trending category");
				System.out.println("******");

		System.out.println(categoryDao.save(category)+ " created with id : "+category.getId());
		List<Category> all = categoryDao.getAll();
		all.stream().forEach(x -> System.out.println(x));
		Category getcategory = categoryDao.get(101);
		System.out.println("******");
		System.out.println(getcategory);
		System.out.println("******");
		categoryDao.delete(102);
		Category	updatedcategory = new Category();
		updatedcategory.setId(103);
		updatedcategory.setTitle("testinggg");
		updatedcategory.setDescription("testinggg");
		categoryDao.update(103,updatedcategory);
		System.out.println("******");
		List<Category> searchTitle = categoryDao.search("Trending");
		System.out.println(searchTitle);
		System.out.println("******");
		System.out.println(categoryDao.count());
		System.out.println("******");
		System.out.println(categoryDao.getCategoryByTitle("testinggg"));
	}*/
}
