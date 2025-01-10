package com.substring.foodie.substring_foodie.example.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
    private String departmentName;
    private String departmentCode;

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
