package com.course.management.course_spring_jdbc_example.dao;

import com.course.management.course_spring_jdbc_example.entities.Category;
import com.course.management.course_spring_jdbc_example.utils.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    //create table
    @PostConstruct
    public void init()
    {
        String createtableQuery = "create table if not exists categories(id int primary key,title varchar(100) not null,description varchar(500))";
        jdbcTemplate.update(createtableQuery);
        System.out.println("Table created");
    }
    //jdbcTemplate.update is used only for insert,update or delete statement
    //queryforobject - select statement
    //save category
    public Category save(Category category)
    {
        //parameterized query
        String query = "insert into categories(id,title,description) values (?,?,?)";
        int rows = jdbcTemplate.update(
                query,
                category.getId(),
                category.getTitle(),
                category.getDescription()
        );
        System.out.println(rows+" effected");
        return category;
    }
    //update category

    public Category update(int categoryId,Category newCat)
    {
       String query = " update categories set title = ?, description = ? where id = ?";
        int rows = jdbcTemplate.update(
                query,
                newCat.getTitle(),
                newCat.getDescription(),
                newCat.getId()
        );
        System.out.println(rows+" updated");
        newCat.setId(categoryId);
        return newCat;
    }
    //get all category
    public List<Category> getAll()
    {
        String query = "Select * from categories";
          //List<Category> categories=jdbcTemplate.queryForList(query,Category.class);
        List<Category> categories=jdbcTemplate.query(query,new CategoryRowMapper());
          return categories;
    }
    //get single category by id
    public Category get(int categoryId)
    {
        String query = "select * from categories where id =?";
       // Category category = jdbcTemplate.queryForObject(query, Category.class, categoryId);
        Category category = jdbcTemplate.queryForObject(query, new CategoryRowMapper(), categoryId);
        return category;
    }

    //delete category

    public void delete(int categoryid)
    {
        String query = " delete from categories where id =?";
         jdbcTemplate.update(query, categoryid);
    }

    public List<Category> search(String title)
    {
        String query = "select * from categories where title like '%"+title+"%'";
        List<Category> categories = jdbcTemplate.query(query, new CategoryRowMapper());
        return  categories;
    }
    public int count()
    {
        String query = "select count(*) as totalcountcategories from categories";
        int count = jdbcTemplate.queryForObject(query, Integer.class);
        return count;
    }
    public List<Category> getCategoryByTitle(String title)
    {
        String query = "select * from categories where title =?";
        List<Category> categories = jdbcTemplate.query(query, new CategoryRowMapper(), title);
        return categories;
    }
}
