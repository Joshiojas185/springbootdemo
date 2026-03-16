package com.springbootdemo.springbootdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>();
    private static int counter = 0;

    public List<Student> getStudents() {
        return  students;
    }

    public Student createStudent(AddStudent addStudent) {
        Student student = new Student(counter, addStudent.getName(),addStudent.getEmail());
        students.add(student);
        counter++;
        return student;
    }
}


