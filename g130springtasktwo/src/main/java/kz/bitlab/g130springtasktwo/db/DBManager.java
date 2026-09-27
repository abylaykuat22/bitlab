package kz.bitlab.g130springtasktwo.db;

import kz.bitlab.g130springtasktwo.entity.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    @Getter
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1L, "Sanzhar", "S", 80, "B"));
        students.add(new Student(2L, "Kuat", "Abylay", 40, "D"));
        students.add(new Student(3L, "Kazy", "M", 50, "D"));
        students.add(new Student(4L, "Alisher", "A", 75, "B"));
    }

    private static Long id = 5L;

    public static void addStudent(Student student) {
        student.setId(id);
        student.setMark(calculateMark(student.getExam()));
        students.add(student);
        id++;
    }

    public static String calculateMark(int exam) {
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

}
