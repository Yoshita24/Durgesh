package com.result.view.result_viewer.repository;

import com.result.view.result_viewer.entities.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepo extends JpaRepository<Marks,String> {
}
