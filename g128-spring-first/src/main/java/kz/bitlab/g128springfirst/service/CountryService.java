package kz.bitlab.g128springfirst.service;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.g128springfirst.entity.Country;
import kz.bitlab.g128springfirst.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  @Autowired
  private CountryRepository countryRepository;

  public void create(Country newCountry) {
    if (newCountry == null) {
      return;
    }

    Country country = getByCode(newCountry.getCode());
    if (country == null) {
      countryRepository.save(newCountry);
    }
  }

  public List<Country> getAll() {
    return countryRepository.findAll();
  }

  public Country getById(Long id) {
    return countryRepository.findById(id).orElse(null);
  }

  public Country getByCode(String code) {
    return countryRepository.findByCode(code).orElse(null);
  }

  public void edit(Country country) {
    countryRepository.save(country);
  }

  public void deleteById(Long id) {
    countryRepository.deleteById(id);
  }
}
