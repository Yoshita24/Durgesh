package org.example.coreconcepts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example.coreconcepts")
public class AppConfig {

    @Bean(name = "teacher")
    public Teacher getTeacher()
    {
        return new Teacher();
    }

}
