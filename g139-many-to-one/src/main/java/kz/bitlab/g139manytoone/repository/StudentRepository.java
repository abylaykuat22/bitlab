package kz.bitlab.g139manytoone.repository;

import kz.bitlab.g139manytoone.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAge(Long age);

    List<Student> findByAgeAndFirstNameIgnoreCase(Long age, String firstName);

    @Query("SELECT s FROM Student s " +
            "WHERE s.age = :age AND s.firstName = :firstName and s.birthCity.id = :cityId")
    List<Student> findStudents(Long age, String firstName, Long cityId);
}
