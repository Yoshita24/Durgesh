package com.result.view.result_viewer.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentForm {
    @NotBlank(message = "Name should not be blank")
    private String name;
    @NotBlank(message = "Roll Number should not be blank")
    private String rollNumber;
    @NotBlank(message = "Email should not be blank")
    private String email;
    private String address;
    private String fatherName;
    private String collegeStudent;
    private String photo;
    private String gender;

    private String dob;
    private String standard;
}
