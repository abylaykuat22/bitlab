package com.example.g139springfirst.service;

import com.example.g139springfirst.model.Student;
import com.example.g139springfirst.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Getter
    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Student Service успешно создан");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Student Service успешно уничтожен");
    }

    public Student addStudent(Student student, Long id) {
        if (student.getPoint() > 90) {
            student.setPointMark("A");
        } else if (student.getPoint() > 80) {
            student.setPointMark("B");
        } else if (student.getPoint() > 70) {
            student.setPointMark("C");
        } else if (student.getPoint() > 60) {
            student.setPointMark("D");
        } else if (student.getPoint() > 50) {
            student.setPointMark("F");
        }

        student.setId(id);
        students.add(student);

        return student;
    }
}
