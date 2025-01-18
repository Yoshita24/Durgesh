package com.result.view.result_viewer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="result_viewer_marks")
public class Marks {
    @Id
    private String marksId;
    private String marks;
    private String totalMarks;
    private String subjectName;
    private String feedback;
    private String grade;
    private String studentId;

    @ManyToOne
    private Student student;
}
