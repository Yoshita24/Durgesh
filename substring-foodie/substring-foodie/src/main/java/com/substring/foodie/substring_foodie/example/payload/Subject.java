package com.substring.foodie.substring_foodie.example.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subject {
    private String title;
    private String subjectCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
