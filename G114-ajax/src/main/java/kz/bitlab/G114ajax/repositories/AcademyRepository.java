package kz.bitlab.G114ajax.repositories;

import kz.bitlab.G114ajax.models.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

}
