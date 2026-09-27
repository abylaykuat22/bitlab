package kz.bitlab.g139manytoone.service;

import kz.bitlab.g139manytoone.entity.Country;
import kz.bitlab.g139manytoone.entity.Student;
import kz.bitlab.g139manytoone.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getNotVisitedCountries(Student student) {
        List<Country> countries = countryRepository.findAll(); // USA, CANADA, FRANCE, ITALY
        List<Country> visitedCountries = student.getVisitedCountries(); // USA, CANADA
        countries.removeAll(visitedCountries); // FRANCE, ITALY
        return countries;
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }
}
