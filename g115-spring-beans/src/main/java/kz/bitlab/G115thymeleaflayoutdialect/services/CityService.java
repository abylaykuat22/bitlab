package kz.bitlab.G115thymeleaflayoutdialect.services;

import java.util.List;
import kz.bitlab.G115thymeleaflayoutdialect.models.City;

public interface CityService {

  List<City> getCities();

  City getCityById(Long id);

  City addCity(City city);

  City editCity(City city);
}
