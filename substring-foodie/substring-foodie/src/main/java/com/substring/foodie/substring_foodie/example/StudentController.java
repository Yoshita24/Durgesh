package com.substring.foodie.substring_foodie.example;

import com.substring.foodie.substring_foodie.example.payload.Department;
import com.substring.foodie.substring_foodie.example.payload.Student;
import com.substring.foodie.substring_foodie.example.payload.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @RequestMapping("/single")
    public Student student()
    {
        String temp=null;
        temp.length();
        Student student = new Student();
        student.setName("AKshansh Sharma");
        student.setAge(22);
    Department department = new Department();
    department.setDepartmentCode("CS");
    department.setDepartmentName("Computer Science");
        student.setDepartment(department);
        Subject subject = new Subject();
        subject.setSubjectCode("KCS");
        subject.setTitle("Data structure");
        Subject subject1 = new Subject();
        subject1.setSubjectCode("CS");
        subject1.setTitle("Data Analysis");
        List<Subject> subjectList = Arrays.asList(subject1,subject);
        student.setSubjects(subjectList);
        return student;

    }
    @RequestMapping("getall-students")
    public List<Student> getStudents()
    {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("AKshansh Sharma");
        student.setAge(22);
        Department department = new Department();
        department.setDepartmentCode("CS");
        department.setDepartmentName("Computer Science");
        student.setDepartment(department);
        Subject subject = new Subject();
        subject.setSubjectCode("KCS");
        subject.setTitle("Data structure");
        Subject subject1 = new Subject();
        subject1.setSubjectCode("CS");
        subject1.setTitle("Data Analysis");
        List<Subject> subjectList = Arrays.asList(subject1,subject);
        student.setSubjects(subjectList);
        students.add(student);

        Student student1 = new Student();
        student1.setName("AKshansh Sharma");
        student1.setAge(22);
        Department department1 = new Department();
        department1.setDepartmentCode("CS");
        department1.setDepartmentName("Computer Science");
        student1.setDepartment(department1);
        Subject subject2 = new Subject();
        subject2.setSubjectCode("KCS");
        subject2.setTitle("Data structure");
        Subject subject3 = new Subject();
        subject3.setSubjectCode("CS");
        subject3.setTitle("Data Analysis");
        List<Subject> subjectList1 = Arrays.asList(subject2,subject3);
        student1.setSubjects(subjectList1);
        students.add(student1);

        return students;
    }
@RequestMapping("/wish/{message}")
    public String wish(@PathVariable("message") String mess)
    {
        return "Hello.... "+mess;
    }

    @RequestMapping("/wis")
    public String wish1(@RequestParam("message") String mess,@RequestParam("user") String user)
    {
        System.out.println("Hellooo wish1");
        return "Hi.... "+mess+" for user "+user;
    }
}
