package com.springbootdemo.springbootdemo;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    List<Student> students = new ArrayList<>();
    private final ModelMapper modelMapper;
    private static int counter = 0;
    public List<Student> getAllStudents(){
        return students;
    }

    public Student addStudent(AddStudent addStudent){
        Student student = modelMapper.map(addStudent, Student.class);
        counter++;
        student.setId(counter);
        students.add(student);
        return student;
    }

    public String deleteStudent(int id) {
        Student removed = students.remove(id);

        if(removed.id > -1){
            return "Student removed successfully";
        }
        return "Student not found";


    }

    public Student updateStudent(int id, AddStudent addStudent) {
        Student update = students.get(id);
        if(update.id > -1){
            update.setName(addStudent.getName());
            update.setEmail(addStudent.getEmail());
            return update;
        }
        throw new IllegalArgumentException("Student not found");

    }
}
