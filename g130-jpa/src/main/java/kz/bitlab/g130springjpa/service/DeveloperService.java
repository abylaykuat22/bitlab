package kz.bitlab.g130springjpa.service;

import kz.bitlab.g130springjpa.entity.Developer;
import kz.bitlab.g130springjpa.entity.ProgrammingLanguage;
import kz.bitlab.g130springjpa.repository.DeveloperRepository;
import kz.bitlab.g130springjpa.repository.ProgrammingLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperRepository developerRepository;
    private final ProgrammingLanguageService programmingLanguageService;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll().stream()
                .sorted(Comparator.comparing(Developer::getId))
                .toList();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer getDeveloperByEmail(String email) {
        return developerRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found" + email));
    }

    public void addDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    public void updateDeveloper(Developer developer) {
        developerRepository.save(developer);
    }

    public void deleteDeveloperById(Long id) {
        developerRepository.deleteById(id);
    }

    public void addProgrammingLanguage(Long developerId, Long programmingLanguageId) {
        Developer developer = getDeveloperById(developerId);
        ProgrammingLanguage programmingLanguage = programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
        if (developer == null || programmingLanguage == null) {
            return;
        }

        developer.getProgrammingLanguages().add(programmingLanguage);
        developerRepository.save(developer);
    }

    public void deleteProgrammingLanguage(Long developerId, Long programmingLanguageId) {
        Developer developer = getDeveloperById(developerId);
        ProgrammingLanguage programmingLanguage = programmingLanguageService.getProgrammingLanguageById(programmingLanguageId);
        if (developer == null || programmingLanguage == null) {
            return;
        }

        developer.getProgrammingLanguages().remove(programmingLanguage);
        developerRepository.save(developer);
    }

}
