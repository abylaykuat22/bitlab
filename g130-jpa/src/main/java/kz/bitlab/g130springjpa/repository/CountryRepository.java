package kz.bitlab.g130springjpa.repository;

import kz.bitlab.g130springjpa.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
