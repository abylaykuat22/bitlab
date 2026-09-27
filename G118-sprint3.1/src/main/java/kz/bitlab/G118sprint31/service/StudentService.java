package kz.bitlab.G118sprint31.service;

import java.util.List;
import kz.bitlab.G118sprint31.model.Student;

public interface StudentService {

  List<Student> getStudents();

  void addStudent(Student student);

  void calculateMark(Student student);
}
