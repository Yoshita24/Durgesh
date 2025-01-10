package com.course.management.course_spring_jdbc_example.utils;


import com.course.management.course_spring_jdbc_example.entities.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseRowMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
       Course course = new Course();
       course.setId(rs.getInt("id"));
       course.setTitle(rs.getString("title"));
       course.setDescription(rs.getString("description"));
        return course;
    }
}
