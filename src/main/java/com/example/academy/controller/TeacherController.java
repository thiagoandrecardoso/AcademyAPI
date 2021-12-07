package com.example.academy.controller;

import com.example.academy.model.Teacher;
import com.example.academy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping("/teacherOpenFile/{id}")
    public ModelAndView accessTeacher(@PathVariable(value = "id") long id){
        ModelAndView mv = new ModelAndView("academy/teacher/TeacherView");
        Teacher teacher = teacherRepository.findById(id);
        mv.addObject("teacher", teacher);
        return mv;
    }
}
