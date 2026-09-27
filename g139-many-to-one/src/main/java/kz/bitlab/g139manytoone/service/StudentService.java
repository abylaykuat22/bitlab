package kz.bitlab.g139manytoone.service;

import kz.bitlab.g139manytoone.entity.Country;
import kz.bitlab.g139manytoone.entity.Student;
import kz.bitlab.g139manytoone.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CountryService countryService;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void addCountry(Long studentId, Long countryId) {
        if (studentId == null || countryId == null) {
            return;
        }

        Student student = getStudentById(studentId);
        Country country = countryService.getCountryById(countryId);
        if (student == null || country == null) {
            return;
        }

        student.getVisitedCountries().add(country);
        studentRepository.save(student);
    }

    public void deleteCountry(Long studentId, Long countryId) {
        if (studentId == null || countryId == null) {
            return;
        }

        Student student = getStudentById(studentId);
        Country country = countryService.getCountryById(countryId);
        if (student == null || country == null) {
            return;
        }

        student.getVisitedCountries().remove(country);
        studentRepository.save(student);
    }

    public List<Student> getStudentsByAge(Long age) {
        return studentRepository.findByAge(age);
    }

    public List<Student> getStudentsByAgeAndFirstName(Long age, String firstName) {
        return studentRepository.findByAgeAndFirstNameIgnoreCase(age, firstName);
    }

    public List<Student> search(Long age, String firstName, Long cityId) {
        return studentRepository.findStudents(age, firstName, cityId);
    }
}
