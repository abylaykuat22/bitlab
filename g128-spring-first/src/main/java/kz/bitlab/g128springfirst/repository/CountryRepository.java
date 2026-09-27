package kz.bitlab.g128springfirst.repository;

import java.util.Optional;
import kz.bitlab.g128springfirst.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

  Optional<Country> findByCode(String code);
}
