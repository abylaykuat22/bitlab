package kz.bitlab.G114ajax.controllers;

import java.util.List;
import kz.bitlab.G114ajax.models.Academy;
import kz.bitlab.G114ajax.repositories.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academies")
public class AcademyController {
  @Autowired
  private AcademyRepository academyRepository;

  @GetMapping
  public List<Academy> getAcademies() {
    return academyRepository.findAll();
  }

  @PostMapping
  public Academy addAcademy(@RequestBody Academy academy) {
    return academyRepository.save(academy);
  }

  @GetMapping("{id}")
  public Academy getAcademy(@PathVariable Long id) {
    return academyRepository.findById(id).orElseThrow();
  }

  @PutMapping
  public Academy editAcademy(@RequestBody Academy academy) {
    System.out.println(academy);
    return academyRepository.save(academy);
  }

  @DeleteMapping("{id}")
  public void deleteAcademy(@PathVariable Long id) {
    academyRepository.deleteById(id);
  }
}
