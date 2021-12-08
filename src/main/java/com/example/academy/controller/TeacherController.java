package com.example.academy.controller;

import com.example.academy.model.Teacher;
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

@Controller
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping("/teacherOpenFile/{id}")
    public ModelAndView accessTeacher(@PathVariable(value = "id") long id) {
        ModelAndView mv = new ModelAndView("academy/teacher/TeacherView");
        Teacher teacher = teacherRepository.findById(id);
        mv.addObject("teacher", teacher);
        return mv;
    }

    @PostMapping("/teacherOpenFile/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            /**
             * Recebe os caracteres em decimal
             */
            byte[] bytes = file.getBytes();

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/teacherOpenFile/1";
    }
}
