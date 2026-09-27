package kz.bitlab.G115sprinttask61.service;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.G115sprinttask61.entity.City;
import kz.bitlab.G115sprinttask61.entity.User;
import kz.bitlab.G115sprinttask61.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  @Autowired
  private CityRepository cityRepository;

  public List<City> getCities(User user) {
    var cities = cityRepository.findAll();
    cities.removeAll(user.getCities());
    return cities;
  }

  public City getCityById(Long cityId) {
    return cityRepository.findById(cityId).orElseThrow();
  }
}
