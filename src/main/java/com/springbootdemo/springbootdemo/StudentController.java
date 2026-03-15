package com.springbootdemo.springbootdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody AddStudent addStudent){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(addStudent));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentDetails(@PathVariable int id, @RequestBody AddStudent addStudent){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id, addStudent));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }


}
