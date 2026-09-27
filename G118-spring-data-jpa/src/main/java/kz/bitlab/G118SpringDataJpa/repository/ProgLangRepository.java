package kz.bitlab.G118SpringDataJpa.repository;

import kz.bitlab.G118SpringDataJpa.model.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgLangRepository extends JpaRepository<ProgrammingLanguage, Long> {

}
