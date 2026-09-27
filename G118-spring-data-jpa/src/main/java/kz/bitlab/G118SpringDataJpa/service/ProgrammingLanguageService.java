package kz.bitlab.G118SpringDataJpa.service;

import java.util.List;
import kz.bitlab.G118SpringDataJpa.model.ProgrammingLanguage;
import kz.bitlab.G118SpringDataJpa.repository.ProgLangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageService {
  @Autowired
  private ProgLangRepository progLangRepository;

  public List<ProgrammingLanguage> getProgrammingLanguages() {
    return progLangRepository.findAll();
  }
}
