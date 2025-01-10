package com.course.management.course_spring_jdbc_example.utils;

import com.course.management.course_spring_jdbc_example.entities.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CategoryRowMapper implements RowMapper<Category> {

    //logic to convert table row to category object
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category    category     = new Category();
        category.setId(rs.getInt("id"));
        category.setDescription(rs.getString("description"));
        category.setTitle(rs.getString("title"));
        return category;
    }
}
