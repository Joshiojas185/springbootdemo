package com.springbootdemo.springbootdemo;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private final ModelMapper modelMapper;

    public List<Student> getAllStudents() {
        return students;
    }

    public Student addStudent(AddStudent addStudent) {

        Student student = modelMapper.map(addStudent,Student.class);
        students.add(student);
        return student;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}