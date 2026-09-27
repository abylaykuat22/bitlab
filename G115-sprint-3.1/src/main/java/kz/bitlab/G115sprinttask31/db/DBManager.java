package kz.bitlab.G115sprinttask31.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kz.bitlab.G115sprinttask31.models.Student;
import lombok.Getter;

public class DBManager {

  @Getter
  private static List<Student> students = new ArrayList<>();

  private static Long id = 4L;

  static {
    students.add(new Student(1L, "China", "China", 90, "A"));
    students.add(new Student(2L, "Danik", "Danik", 70, "B"));
    students.add(new Student(3L, "Misha", "Misha", 60, "C"));
  }

  public static void addStudent(Student student) {
    student.setId(id);
    id++;
    student.setMark(getMarkByExam(student.getExam()));
    students.add(student);
  }

  public static Student getStudentById(Long id) {
    return students.stream()
        .filter(student -> Objects.equals(student.getId(), id))
        .findFirst()
        .orElseThrow();
  }

  public static void editStudent(Long id, String name, String surname, int exam) {
    Student student = getStudentById(id);
    student.setName(name);
    student.setSurname(surname);
    student.setExam(exam);
    student.setMark(getMarkByExam(exam));
  }

  private static String getMarkByExam(int exam) {
    if (exam >= 90) {
      return "A";
    } else if (exam >= 75) {
      return "B";
    } else if (exam >= 60) {
      return "C";
    } else if (exam >= 50) {
      return "D";
    } else {
      return "F";
    }
  }

  public static void deleteById(Long id) {
    students.removeIf(student -> Objects.equals(student.getId(), id));
  }
}
