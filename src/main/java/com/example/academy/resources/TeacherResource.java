package com.example.academy.resources;

import com.example.academy.model.Teacher;
import com.example.academy.repository.TeacherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherResource {
    TeacherRepository teacherRepository;

    @GetMapping("/list")
    public List<Teacher> getTeacherList() {
        return teacherRepository.findAll();
    }
}
