package com.example.academy.resources;

import com.example.academy.model.Student;
import com.example.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentResource {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/list")
    public List<Student> studentList(){
        return studentRepository.findAll();
    }
}
