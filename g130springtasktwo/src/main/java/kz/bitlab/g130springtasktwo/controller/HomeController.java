package kz.bitlab.g130springtasktwo.controller;

import kz.bitlab.g130springtasktwo.db.DBManager;
import kz.bitlab.g130springtasktwo.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        List<Student> students = DBManager.getStudents();
        model.addAttribute("studentter", students);
        return "home";
    }

    @GetMapping("/student/add")
    public String studentAddPage() {
        return "student-add";
    }

    @PostMapping("/student/add")
    public String studentAdd(Student student) {
        DBManager.addStudent(student);
        return "redirect:/";
    }
}
