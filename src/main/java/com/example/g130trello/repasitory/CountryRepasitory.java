package com.example.g130trello.repasitory;

import com.example.g130trello.entity.Country;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepasitory extends JpaRepository<Country,Long> {


    Optional<Country> findByCode(String code);
}
