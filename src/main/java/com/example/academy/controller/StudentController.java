package com.example.academy.controller;

import com.example.academy.model.Student;
import com.example.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "/getstudent/{registration}")
    public ModelAndView studentByRegistration(@PathVariable(value = "registration") long registration){
        ModelAndView mv = new ModelAndView("academy/students/StudentView");
        Student student = studentRepository.findByRegistration(registration);
        mv.addObject("student", student);
        return mv;
    }
}
