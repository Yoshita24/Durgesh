package com.course.management.course_spring_jdbc_example.dao;

import com.course.management.course_spring_jdbc_example.entities.Category;
import com.course.management.course_spring_jdbc_example.entities.Course;
import com.course.management.course_spring_jdbc_example.entities.CourseCategoryData;
import com.course.management.course_spring_jdbc_example.utils.CourseRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CategoryDao categoryDao;
    /*@PostConstruct
    public void init()
    {
        //String createTableQuery = "create table if not exists course(id int primary key,title varchar(100) not null,description varchar(500))";
        String createTableQuery ="create table if not exists course(\n" +
                "    id int primary key,\n" +
                "    title varchar(100) not null,\n" +
                "    description varchar(500),\n" +
                "    category_id int not null,\n" +
                "    foreign key(category_id) references categories(id)\n" +
                "    on delete cascade\n" +
                "    on update cascade\n" +
                ")";
        jdbcTemplate.update(createTableQuery);
        System.out.println("table created");
    }*/

    //create course
    public Course createCourse(Course course)
    {
        String query =  "insert into course(id,title,description,category_id) values (?,?,?,?)";
        jdbcTemplate.update(query,course.getId(),course.getTitle(),course.getDescription(),course.getCategoryId());
        return course;
    }
    public Course update( Course newCat)
    {
        String query = " update course set title = ?, description = ? where id = ?";
        int rows = jdbcTemplate.update(
                query,
                newCat.getTitle(),
                newCat.getDescription(),
                newCat.getId()
        );
        System.out.println(rows+" updated");
        return newCat;
    }

    public Course getCourse(int id)
    {
        String query = "select * from course where id =?";
        Course course = jdbcTemplate.queryForObject(query, new CourseRowMapper(), id);
        return course;
    }

    public List<Course> getAllCourse(){
        String query = " select * from course";
        List<Course> course = jdbcTemplate.query(query,new CourseRowMapper());
        return course;
    }
    public void deleteCouse(int id)
    {
        String query = "delete from course where id =?";
        jdbcTemplate.update(query,id);
    }

    public List<CourseCategoryData> getCourseCategoryJoinData()
    {
        String query = "select cat.title,cat.description,cou.description,cou.title\n" +
                "from\n" +
                "categories cat inner join course cou\n" +
                "on cat.id = cou.category_id";
      List<CourseCategoryData> courseCategoryData1=  jdbcTemplate.query(query,(rs,rowNum)->
        {
            CourseCategoryData courseCategoryData = new CourseCategoryData();
            courseCategoryData.setCategoryDesc(rs.getString("cat.description"));
            courseCategoryData.setCourseDesc(rs.getString("cou.description"));
            courseCategoryData.setCategoryTitle(rs.getString("cat.title"));
            courseCategoryData.setCourseTitle(rs.getString("cou.title"));
return courseCategoryData;

        });
      return courseCategoryData1;
    }

    //insert course in batch
    public void saveCourseinbatch(List<Course> courses)
    {
        //single query
        String query =  "insert into course(id,title,description,category_id) values (?,?,?,?)";
        jdbcTemplate.batchUpdate(query,courses,courses.size(),((ps, course) -> {
            ps.setInt(1,course.getId());
            ps.setString(2,course.getTitle());
            ps.setString(3,course.getDescription());
            ps.setInt(4,course.getCategoryId());

        }));

    }

    //transaction management
    @Transactional
    public void saveCategoryThanCourse(Category category, Course course)
    {
        //inserting category code
        //inserting category query
        //jdbc fire
        //save
        //inserting course code
        //inserting course query
        //jdbc fire
        //save
        categoryDao.save(category);
        createCourse(course);
        //if any of the above fails to save db then whole will rollback
    }
}
