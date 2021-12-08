package com.example.academy.resources;

import com.example.academy.model.Teacher;
import com.example.academy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherResource {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/list")
    public List<Teacher> getTeacherList() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable(value = "id") long id) {
        return teacherRepository.findById(id);
    }

    @PostMapping("/save")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/delete")
    public void deleteTeacher(@RequestBody Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @PutMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
