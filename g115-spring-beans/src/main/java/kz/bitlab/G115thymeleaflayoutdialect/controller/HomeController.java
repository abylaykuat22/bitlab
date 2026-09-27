package kz.bitlab.G115thymeleaflayoutdialect.controller;

import java.util.List;
import kz.bitlab.G115thymeleaflayoutdialect.models.City;
import kz.bitlab.G115thymeleaflayoutdialect.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

  @Autowired
  @Qualifier("cityservice1")
  private CityService cityService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<City> cities = cityService.getCities();
    model.addAttribute("goroda", cities);
    return "home";
  }

  @GetMapping("/second-page")
  public String secondPage() {
    return "second-page";
  }

  @GetMapping("/details/{id}")
  public String details(@PathVariable Long id, Model model) {
    City city = cityService.getCityById(id);
    model.addAttribute("gorod", city);
    return "details";
  }
}
