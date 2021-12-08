package com.example.academy.resources;

import com.example.academy.model.Student;
import com.example.academy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentResource {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/list")
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @GetMapping("/{registration}")
    public Student getStudentByRegistration(@PathVariable(value = "registration") long registration) {
        return studentRepository.findByRegistration(registration);
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentRepository.delete(student);
    }

    @PutMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentRepository.delete(student);
    }
}
