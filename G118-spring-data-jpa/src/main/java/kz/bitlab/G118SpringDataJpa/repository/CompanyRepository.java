package kz.bitlab.G118SpringDataJpa.repository;

import kz.bitlab.G118SpringDataJpa.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
