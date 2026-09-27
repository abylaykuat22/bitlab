package kz.bitlab.G115sprinttask61.controller;

import java.util.List;
import kz.bitlab.G115sprinttask61.entity.ApplicationRequest;
import kz.bitlab.G115sprinttask61.entity.City;
import kz.bitlab.G115sprinttask61.entity.Course;
import kz.bitlab.G115sprinttask61.entity.User;
import kz.bitlab.G115sprinttask61.service.ApplicationRequestService;
import kz.bitlab.G115sprinttask61.service.CityService;
import kz.bitlab.G115sprinttask61.service.CourseService;
import kz.bitlab.G115sprinttask61.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
  private final ApplicationRequestService appReqService;
  private final CourseService courseService;
  private final UserService userService;
  private final CityService cityService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<ApplicationRequest> appRequests = appReqService.getAppRequests();
    List<Course> courses = courseService.getCourses();
    model.addAttribute("zayavki", appRequests);
    model.addAttribute("kursy", courses);
    return "home";
  }

  @PostMapping("/add-app-req")
  public String addAppReq(ApplicationRequest appReq) {
    appReqService.addAppReq(appReq);
    return "redirect:/";
  }

  @GetMapping("/details/{id}")
  public String details(@PathVariable Long id, Model model) {
    ApplicationRequest appReq = appReqService.getAppReqById(id);
    List<Course> courses = courseService.getCourses();
    model.addAttribute("zayavka", appReq);
    model.addAttribute("kursy", courses);
    return "details";
  }

  @PostMapping("/edit-app-req")
  public String editAppReq(ApplicationRequest appReq) {
    appReqService.editAppReq(appReq);
    return "redirect:/";
  }

  @PostMapping("/delete-app-req/{id}")
  public String deleteAppReq(@PathVariable Long id) {
    appReqService.deleteAppReqById(id);
    return "redirect:/";
  }

  @GetMapping("/users")
  public String getUsers(Model model) {
    var users = userService.getUsers();
    model.addAttribute("users", users);
    return "usersPage";
  }

  @GetMapping("/users/{id}")
  public String getUser(@PathVariable Long id, Model model) {
    var user = userService.getUserById(id);
    var cities = cityService.getCities(user);
    model.addAttribute("user", user);
    model.addAttribute("cities", cities);
    return "userDetails";
  }

  @PostMapping("/users/add-city")
  public String addCityToUser(@RequestParam(name = "user_id") Long userId,
      @RequestParam(name = "city_id") Long cityId) {
    userService.addCity(userId, cityId);
    return "redirect:/users/"+userId;
  }

  @PostMapping("/users/delete-city")
  public String deleteCityFromUser(@RequestParam(name = "user_id") Long userId,
      @RequestParam(name = "city_id") Long cityId) {
    userService.deleteCity(userId, cityId);
    return "redirect:/users/"+userId;
  }
}
