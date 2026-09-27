package kz.bitlab.g128springrestapi.service;

import kz.bitlab.g128springrestapi.dtos.StudentCreate;
import kz.bitlab.g128springrestapi.dtos.StudentEdit;
import kz.bitlab.g128springrestapi.dtos.StudentView;
import kz.bitlab.g128springrestapi.entity.Student;
import kz.bitlab.g128springrestapi.mapper.StudentMapper;
import kz.bitlab.g128springrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentView> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return StudentMapper.INSTANCE.toDtoList(students);
    }

    public StudentView getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return StudentMapper.INSTANCE.toDto(student);
    }

    public void create(StudentCreate studentCreate) {
        Student student = studentRepository.findByEmail(studentCreate.getEmail()).orElse(null);
        if (student != null) {
            throw new RuntimeException("Student already exists");
        }

        if (!Objects.equals(studentCreate.getPassword(), studentCreate.getRePassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        Student newStudent = StudentMapper.INSTANCE.toEntity(studentCreate);
        saveStudent(newStudent);
    }

    public void update(StudentEdit studentEdit) {
        Student student = studentRepository.findByEmail(studentEdit.getEmail()).orElse(null);
        if (student != null) {
            throw new RuntimeException("Student already exists");
        }

        if (!Objects.equals(studentEdit.getPassword(), studentEdit.getRePassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        Student updatedStudent = StudentMapper.INSTANCE.toEntity(studentEdit);
        saveStudent(updatedStudent);
    }

    public void saveStudent(Student student) {
        Integer exam = student.getExam();

        if (exam != null) {
            if (exam >= 90) {
                student.setMark("A");
            } else if (exam >= 75) {
                student.setMark("B");
            } else if (exam >= 60) {
                student.setMark("C");
            } else if (exam >= 50) {
                student.setMark("D");
            } else {
                throw new IllegalArgumentException("Invalid exam");
            }
        }

        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentView> findAllByExam(Integer exam) {

        List<Student> students = studentRepository.findAllByExamGreaterThanEqual(exam);
        return StudentMapper.INSTANCE.toDtoList(students);
    }


}
