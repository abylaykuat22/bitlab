package kz.bitlab.G118SpringDataJpa.repository;

import java.util.List;
import kz.bitlab.G118SpringDataJpa.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
  Developer findByEmail(String email);

  @Query("SELECT d FROM Developer d "
      + "WHERE d.fullName ilike concat('%', :search, '%') "
      + "OR d.email ilike concat('%', :search, '%') "
      + "OR d.programmingLanguage.name ilike concat('%', :search, '%') ")
  List<Developer> findAllByText(String search);
}
