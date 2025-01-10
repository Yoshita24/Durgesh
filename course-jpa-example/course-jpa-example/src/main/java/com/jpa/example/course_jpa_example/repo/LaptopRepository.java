package com.jpa.example.course_jpa_example.repo;

import com.jpa.example.course_jpa_example.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
