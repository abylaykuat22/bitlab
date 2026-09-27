package kz.bitlab.G118sprint31.controller;

import java.util.List;
import kz.bitlab.G118sprint31.model.Student;
import kz.bitlab.G118sprint31.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  @Autowired
  @Qualifier("studentServiceImpl")
  private StudentService studentService;

  @Autowired
  @Qualifier("studentServiceAltImpl")
  private StudentService studentServiceAlt;

  @GetMapping("/")
  public String home(Model model) {
    List<Student> students = studentService.getStudents();
    model.addAttribute("students", students);
    return "home";
  }

  @GetMapping("/add-student")
  public String addStudentPage() {
    return "addstudent";
  }

  @PostMapping("/add-student")
  public String addStudent(Student student) {
    studentService.addStudent(student);
    return "redirect:/";
  }

  @PostMapping("/add-student-alt")
  public String addStudentAlt(Student student) {
    studentServiceAlt.addStudent(student);
    return "redirect:/";
  }
}
