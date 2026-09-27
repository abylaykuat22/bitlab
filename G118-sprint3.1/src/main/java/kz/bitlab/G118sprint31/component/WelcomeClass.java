package kz.bitlab.G118sprint31.component;

import kz.bitlab.G118sprint31.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WelcomeClass {

  @Autowired
  @Qualifier("studentServiceImpl")
  private StudentService studentService;

  @Scheduled(fixedDelay = 5000)
  void sayHello() {
    var students = studentService.getStudents();
    System.out.println(students);
  }
}
