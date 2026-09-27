package com.example.g139springfirst.controller;

import com.example.g139springfirst.model.Student;
import com.example.g139springfirst.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private Long id = 1L;

    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/students/add")
    public String addStudent(Student student) {
        studentService.addStudent(student, id);
        id++;
        return "redirect:/students";
    }
}
