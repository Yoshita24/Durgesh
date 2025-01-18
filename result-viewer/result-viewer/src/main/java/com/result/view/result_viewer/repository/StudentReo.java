package com.result.view.result_viewer.repository;

import com.result.view.result_viewer.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentReo extends JpaRepository<Student,String> {

    Optional<Student> findByRollNumber(String rollNumber);
    Optional<Student> findByEmail(String email);

}
