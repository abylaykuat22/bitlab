package kz.bitlab.g128springrestapi.repository;

import kz.bitlab.g128springrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByExamGreaterThanEqual(Integer exam);

    Optional<Student> findByEmail(String email);

}
