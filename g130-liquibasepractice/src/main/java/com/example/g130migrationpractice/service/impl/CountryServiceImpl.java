package com.example.g130migrationpractice.service.impl;

import com.example.g130migrationpractice.entity.Country;
import com.example.g130migrationpractice.exception.EntityNotFoundException;
import com.example.g130migrationpractice.repository.CountryRepository;
import com.example.g130migrationpractice.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Country not found"));
    }
}
