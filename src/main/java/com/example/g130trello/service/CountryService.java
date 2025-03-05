package com.example.g130trello.service;

import com.example.g130trello.dto.CountryRequestDto;
import com.example.g130trello.dto.CountryResponseDto;
import com.example.g130trello.entity.Country;

import java.util.List;

public interface CountryService {


    List<CountryResponseDto> getCountries();

    CountryResponseDto getCountryById(Long id);

    void createCountry(CountryRequestDto countryRequestDto);

    CountryResponseDto updateCode(Long id,String code);

    CountryResponseDto updateCountry(CountryResponseDto countryResponseDto);

    void deleteCountry(Long id);


}
