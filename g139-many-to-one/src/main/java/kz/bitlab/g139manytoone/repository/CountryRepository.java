package kz.bitlab.g139manytoone.repository;

import kz.bitlab.g139manytoone.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
