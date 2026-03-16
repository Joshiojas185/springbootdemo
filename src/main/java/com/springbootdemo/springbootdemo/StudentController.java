package com.springbootdemo.springbootdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
 private final StudentService studentService;
// StudentController(StudentService studentService) {
//  this.studentService = studentService;
// }


 @GetMapping("/students")
 public List<Student> getStudents(){
  return studentService.getStudents();
 }

 @PostMapping("/student")
 public Student createStudent(@RequestBody AddStudent addStudent){
  return studentService.createStudent(addStudent);
 }


}
