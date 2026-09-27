package kz.bitlab.g128finalproject.controller;

import kz.bitlab.g128finalproject.entity.Developer;
import kz.bitlab.g128finalproject.service.DeveloperService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public List<Developer> getDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public Developer getDeveloper(@PathVariable Long id) {
        return developerService.getDeveloperById(id);
    }

    @PostMapping
    public void addDeveloper(@RequestBody Developer developer) {
        developerService.addDeveloper(developer);
    }

    @PutMapping
    public void updateDeveloper(@RequestBody Developer developer) {

    }

    @DeleteMapping("/{id}")
    public void deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloperById(id);
    }
}
