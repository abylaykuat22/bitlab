package com.example.g139springfirst.controller;

import com.example.g139springfirst.model.Car;
import com.example.g139springfirst.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CarService carService;

    @GetMapping("/")
    public String home(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("mashiny", cars);
        return "test";
    }

    @PostMapping("/cars/add")
    public String addCar(Car car) {
        carService.addCar(car);
        return "redirect:/";
    }

    @GetMapping("/cars/{id}")
    public String getCar(@PathVariable Long id, Model model) {
        Car car = carService.getCarById(id);
        model.addAttribute("mashina", car);
        return "car-details";
    }

    @GetMapping("/cars/get-by-name")
    public String getCarByName(@RequestParam String name, Model model) {
        model.addAttribute("mashiny", new Car());
        return "test";
    }

    @PostMapping("/cars/delete/{id}")
    public String deleteCarById(@PathVariable Long id) {
        carService.deleteCarById(id);
        return "redirect:/";
    }

    @PostMapping("/cars/update")
    public String updateCar(Car car) {
        carService.updateCar(car);
        return "redirect:/";
    }


}
