package com.java.springdemo.notes.service;

import com.java.springdemo.notes.model.Student;
import com.java.springdemo.notes.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
public class StudentServiceImpl implements StudentService{
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Override
//    @Transactional
//    public List<Student> retrieveListOfStudents() {
//        return (List<Student>)studentRepository.findAll();
//    }
//
//    @Override
//    public Student retrieveStudentById(int id) {
//        return studentRepository.findById(id).get();
//    }
//
//    @Override
//    @Transactional
//    public String addStudent(Student student) {
//        studentRepository.save(student);
//        String message = "Saving failed";
//        if(retrieveStudentById(student.getId()) != null) {
//            message = "Successfully saved in the database";
//        }
//        return message;
//    }
//
//    @Override
//    @Transactional
//    public String updateStudent(Student student) {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public String deleteStudent(int id) {
//        return null;
//    }
}
