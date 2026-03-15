package com.springbootdemo.springbootdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final static List<Student> list = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return list;
    }

    @PostMapping("students")
    public Student addNewStudent(@RequestBody Student student){
        list.add(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        list.remove(id);
        return "Student at id:" + id + "removed successfully";
    }
}
