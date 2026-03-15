package com.springbootdemo.springbootdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean removed = studentService.deleteStudent(id);
        if (removed) {
            return ResponseEntity.ok("Student with ID " + id + " removed successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found.");
    }
}