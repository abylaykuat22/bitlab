package kz.bitlab.g139manytoone.service;

import kz.bitlab.g139manytoone.entity.City;
import kz.bitlab.g139manytoone.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getCities() {
        return cityRepository.findAll();
    }
}
