package kz.bitlab.g130springjpa.service;

import kz.bitlab.g130springjpa.entity.Developer;
import kz.bitlab.g130springjpa.entity.ProgrammingLanguage;
import kz.bitlab.g130springjpa.repository.ProgrammingLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageService {

    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public List<ProgrammingLanguage> getAllProgrammingLanguages() {
        return programmingLanguageRepository.findAll();
    }

    public ProgrammingLanguage getProgrammingLanguageById(Long id) {
        return programmingLanguageRepository.findById(id).orElse(null);
    }

    public List<ProgrammingLanguage> getAllDeveloperNotKnowLanguages(Developer developer) {
        List<ProgrammingLanguage> programmingLanguages = getAllProgrammingLanguages();
        programmingLanguages.removeAll(developer.getProgrammingLanguages());
        return programmingLanguages;
    }
}
