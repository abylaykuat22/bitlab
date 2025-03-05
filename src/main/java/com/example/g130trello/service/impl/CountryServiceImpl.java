package com.example.g130trello.service.impl;

import com.example.g130trello.dto.CountryRequestDto;
import com.example.g130trello.dto.CountryResponseDto;
import com.example.g130trello.entity.Country;
import com.example.g130trello.exception.EntityNotFoundException;
import com.example.g130trello.exception.EntityUniqueException;
import com.example.g130trello.mapper.CountryMapper;
import com.example.g130trello.repasitory.CountryRepository;
import com.example.g130trello.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<CountryResponseDto> getCountries() {
        return countryRepository.findAll()
                .stream()
                .map(country -> CountryMapper.INSTANCE.toDto(country))
                .toList();
    }

    @Override
    public CountryResponseDto getCountryById(Long id) {
        return countryRepository.findById(id)
                .map(country -> CountryMapper.INSTANCE.toDto(country))
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));
    }

    @Override
    public void createCountry(CountryRequestDto countryRequestDto) {
        Country country = CountryMapper.INSTANCE.toEntity(countryRequestDto);
        countryRepository.save(country);
    }

    @Override
    public CountryResponseDto updateCode(Long id, String code) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));
        boolean excists = countryRepository.findByCode((code))
                .isPresent();
        if (excists)
            throw new EntityUniqueException("Уже есть такой код");
        countryRepository.save(country);
        return CountryMapper.INSTANCE.toDto(country);
    }

    @Override
    public CountryResponseDto updateCountry(CountryResponseDto countryResponseDto) {
        countryRepository.findById(countryResponseDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));
        countryRepository.save(CountryMapper.INSTANCE.toEntityResponse(countryResponseDto));
        return countryResponseDto;
    }

    @Override
    public void deleteCountry(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country not found"));
        countryRepository.delete(country);
    }


}
