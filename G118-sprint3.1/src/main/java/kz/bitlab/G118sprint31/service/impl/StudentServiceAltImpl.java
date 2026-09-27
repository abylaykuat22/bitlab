package kz.bitlab.G118sprint31.service.impl;

import java.util.List;
import kz.bitlab.G118sprint31.db.DbManager;
import kz.bitlab.G118sprint31.model.Student;
import kz.bitlab.G118sprint31.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Qualifier("studentServiceAltImpl")
@Service
public class StudentServiceAltImpl implements StudentService {
  private static Long id = 4L;

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
    switch (exam) {
      case 1:
        student.setMark("Ужасно");
        break;
      case 2:
        student.setMark("Очень плохо");
        break;
      case 3:
        student.setMark("Удовлетворительно");
        break;
      case 4:
        student.setMark("Хорошо");
        break;
      case 5:
        student.setMark("Отлично!");
        break;
      default:
        break;
    }
  }
}
