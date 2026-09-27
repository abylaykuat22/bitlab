package kz.bitlab.g130springjpa.service;

import kz.bitlab.g130springjpa.entity.Country;
import kz.bitlab.g130springjpa.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
