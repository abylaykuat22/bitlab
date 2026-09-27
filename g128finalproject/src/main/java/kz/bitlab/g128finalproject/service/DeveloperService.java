package kz.bitlab.g128finalproject.service;

import kz.bitlab.g128finalproject.entity.Developer;
import kz.bitlab.g128finalproject.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private ProgrammingLanguageService programmingLanguageService;
    @Autowired
    private WorkingFormatService workingFormatService;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public void addDeveloper(Developer developer) {
        Double baseSalary = programmingLanguageService.getBaseSalary(developer.getProgrammingLanguage());
        Double bonusPercentage = workingFormatService.getBonusPercentage(developer.getWorkingFormat());
        double salary = baseSalary * bonusPercentage;
        developer.setSalary(salary);
        developerRepository.save(developer);
    }

    public void addDeveloperFromExcel(Developer developer) {
        developerRepository.save(developer);
    }

    public void deleteDeveloperById(Long id) {
        developerRepository.deleteById(id);
    }
}
