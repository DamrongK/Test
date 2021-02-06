package com.okta.springbootvue.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.okta.springbootvue.entity.test.*;
import com.okta.springbootvue.repository.test.*;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;
 
    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public Collection<Student> Student() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/student/{stuCode}")
    public Collection<Student> getByStuCode(@PathVariable String stuCode) {
        return studentRepository.findByStuCode(stuCode);
    }

    @PostMapping("/student/{stuCode}/{name}/{subject}/{tel}")
    
    public Student newStudent(Student newStudent,
    @PathVariable String stuCode,
    @PathVariable String name,
    @PathVariable String subject,
    @PathVariable String tel) {
 
    newStudent.setStuCode(stuCode);
    newStudent.setName(name);
    newStudent.setSubject(subject);
    newStudent.setTel(tel);
    return studentRepository.save(newStudent);
    }
}