package kz.bitlab.G118SpringDataJpa.service;

import java.util.List;
import kz.bitlab.G118SpringDataJpa.model.Developer;
import kz.bitlab.G118SpringDataJpa.repository.CompanyRepository;
import kz.bitlab.G118SpringDataJpa.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

  @Autowired
  private DeveloperRepository developerRepository;
  @Autowired
  private CompanyRepository companyRepository;

  public List<Developer> search(String search) {
    return developerRepository.findAllByText(search);
  }

  public void addCompany(Long developerId, Long companyId) {
    if (developerId == null || companyId == null) {
      return;
    }
    var developer = developerRepository.findById(developerId).orElseThrow();
    var company = companyRepository.findById(companyId).orElseThrow();
    developer.getCompanies().add(company);
    developerRepository.save(developer);
  }

  public void deleteCompany(Long developerId, Long companyId) {
    if (developerId == null || companyId == null) {
      return;
    }
    var developer = developerRepository.findById(developerId).orElseThrow();
    var company = companyRepository.findById(companyId).orElseThrow();
    developer.getCompanies().remove(company);
    developerRepository.save(developer);
  }
}
