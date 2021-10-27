package com.java.springdemo.notes.controller;

import com.java.springdemo.notes.model.Student;
import com.java.springdemo.notes.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
public class StudentController {

//    @Autowired
//    StudentService studentService;
//
//    @GetMapping("/students/all")
//    public List<Student> getAllStudents() {
//        return studentService.retrieveListOfStudents();
//    }
//
//    @GetMapping("/students/{id}")
//    public Student getStudentById(int id) {
//        return studentService.retrieveStudentById(id);
//    }
//
//    @PostMapping("/students")
//    public String addStudent(@RequestBody Student student) {
//        return studentService.addStudent(student);
//    }
//
//    @PutMapping("/students")
//    public String updateStudent(@RequestBody Student student) {
//        return studentService.updateStudent(student);
//    }
//
//    @DeleteMapping("/students")
//    public String deleteStudent(int id) {
//        return null;
//    }
}
