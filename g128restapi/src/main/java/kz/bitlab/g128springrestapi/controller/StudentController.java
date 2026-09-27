package kz.bitlab.g128springrestapi.controller;

import kz.bitlab.g128springrestapi.dtos.StudentCreate;
import kz.bitlab.g128springrestapi.dtos.StudentEdit;
import kz.bitlab.g128springrestapi.dtos.StudentView;
import kz.bitlab.g128springrestapi.entity.Student;
import kz.bitlab.g128springrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentView> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentView> getStudent(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(studentService.getStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody StudentCreate studentCreate) {
        try {
            studentService.create(studentCreate);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Неверные данные, повторите попытку!");
        }
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentEdit student) {
        studentService.update(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/find-by-exam")
    public List<StudentView> findStudents(@RequestParam Integer exam) {
        return studentService.findAllByExam(exam);

    }

}
