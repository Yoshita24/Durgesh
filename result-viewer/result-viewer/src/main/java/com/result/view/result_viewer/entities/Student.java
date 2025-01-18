package com.result.view.result_viewer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="result_viewer_student")
public class Student {
    @Id
    private String studentId;
    private String name;
    private String rollNumber;
    private String email;
    @Column(length = 1000)
    private String address;
    private String fatherName;
    private String collegeStudent;
    private String photo;
    private String gender;
    private String dob;
    private String standard;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Marks> marksList = new ArrayList<>();
}
