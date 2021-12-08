package com.example.academy.controller;

import com.example.academy.model.Student;
import com.example.academy.model.Teacher;
import com.example.academy.repository.StudentRepository;
import com.example.academy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;
    private List<Student> studentList = new ArrayList<>();

    @RequestMapping("/teacherOpenFile/{id}")
    public ModelAndView accessTeacher(@PathVariable(value = "id") long id) {
        ModelAndView mv = new ModelAndView("academy/teacher/TeacherView");
        Teacher teacher = teacherRepository.findById(id);
        mv.addObject("teacher", teacher);
        return mv;
    }

    @PostMapping("/teacherOpenFile/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();

            String csvText = decimalToCharASCII(bytes);
            String[] splitLine = splitLine(csvText);

            for (String s : splitLine){
                String[] regAndScore = s.split(" ");
                Student student = studentRepository.findByRegistration(Long.parseLong(regAndScore[0]));
                student.setSocre(Double.parseDouble(regAndScore[1]));
                studentRepository.save(student);
            }

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/teacherOpenFile/1";
    }

    public String decimalToCharASCII(byte[] bytes){
        StringBuilder charAscii;
        charAscii = new StringBuilder();
        for (byte aByte : bytes) {
            charAscii.append(Character.toString((char) aByte));
        }return charAscii.toString();
    }

    public String[] splitLine(String csvText){
        return csvText.split("\n");
    }

}
