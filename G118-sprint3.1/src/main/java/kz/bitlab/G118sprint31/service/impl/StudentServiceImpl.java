package kz.bitlab.G118sprint31.service.impl;

import java.util.List;
import kz.bitlab.G118sprint31.db.DbManager;
import kz.bitlab.G118sprint31.model.Student;
import kz.bitlab.G118sprint31.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("studentServiceImpl")
@Service
public class StudentServiceImpl implements StudentService {

  private static Long id = 4L;

  public StudentServiceImpl() {
    System.out.println("studentService bean is created!");
  }

  public void sayHello() {
    System.out.println("Hello");
  }

  @Override
  public List<Student> getStudents() {
    return DbManager.getStudents();
  }

  @Override
  public void addStudent(Student student) {
    var students = getStudents();
    student.setId(id);
    id++;
    calculateMark(student);
    students.add(student);
  }

  @Override
  public void calculateMark(Student student) {
    var exam = student.getExam();
    if (exam == null) {
      return;
    }
    if (exam >= 90) {
      student.setMark("A");
    } else if (exam >= 75) {
      student.setMark("B");
    } else if (exam >= 60) {
      student.setMark("C");
    } else if (exam >= 50) {
      student.setMark("D");
    } else {
      student.setMark("F");
    }
  }
}
