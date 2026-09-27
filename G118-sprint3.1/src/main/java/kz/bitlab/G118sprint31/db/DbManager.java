package kz.bitlab.G118sprint31.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.G118sprint31.model.Student;
import lombok.Getter;

public class DbManager {

  @Getter
  private static List<Student> students = new ArrayList<>();

  static {
    students.add(new Student(1L, "Alizhan", "Alizhan", 80, "B"));
    students.add(new Student(2L, "Elnur", "Elnur", 80, "B"));
    students.add(new Student(3L, "Student1", "Student1", 20, "F"));
  }

}
