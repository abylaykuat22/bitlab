package kz.bitlab.G115thymeleaflayoutdialect.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kz.bitlab.G115thymeleaflayoutdialect.models.City;
import kz.bitlab.G115thymeleaflayoutdialect.services.CityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "cityservice2")
public class CityServiceImpl2 implements CityService {

  private List<City> cities = new ArrayList<>();

  {
    cities.add(new City(1L, "Almaty", "ALM"));
    cities.add(new City(2L, "Astana", "AST"));
    cities.add(new City(3L, "NEW-YORK", "NWR"));
    cities.add(new City(4L, "London", "LND"));
  }

  @Override
  public List<City> getCities() {
    return cities.stream()
        .sorted(Comparator.comparing(City::getName).reversed())
        .toList();
  }

  @Override
  public City getCityById(Long id) {
    return null;
  }

  @Override
  public City addCity(City city) {
    return null;
  }

  @Override
  public City editCity(City city) {
    return null;
  }
}
