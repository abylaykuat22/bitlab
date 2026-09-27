package kz.bitlab.g130springjdbc.controller;

import kz.bitlab.g130springjdbc.entity.Country;
import kz.bitlab.g130springjdbc.service.CountryService;
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

    private final CountryService countryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "home";
    }

    @GetMapping("/countries/{id}")
    public String countryDetails(Model model, @PathVariable Long id) {
        Country country = countryService.getCountryById(id);
        model.addAttribute("country", country);
        return "country";
    }

    @PostMapping("/countries/add")
    public String addCountry(Country country) {
        countryService.addCountry(country);
        return "redirect:/";
    }
}
