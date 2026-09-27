package kz.bitlab.G115sprinttask61.service;

import java.util.List;
import kz.bitlab.G115sprinttask61.entity.City;
import kz.bitlab.G115sprinttask61.entity.User;
import kz.bitlab.G115sprinttask61.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final CityService cityService;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("USER NOT FOUND"));
  }

  public void addCity(Long userId, Long cityId) {
    var user = getUserById(userId);
    var city = cityService.getCityById(cityId);
    user.getCities().add(city);
    userRepository.save(user);
  }

  public void deleteCity(Long userId, Long cityId) {
    var user = getUserById(userId);
    var city = cityService.getCityById(cityId);
    user.getCities().remove(city);
    userRepository.save(user);
  }
}
