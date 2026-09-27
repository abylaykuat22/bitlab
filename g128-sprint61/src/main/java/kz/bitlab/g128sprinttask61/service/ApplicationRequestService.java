package kz.bitlab.g128sprinttask61.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kz.bitlab.g128sprinttask61.entity.ApplicationRequest;
import kz.bitlab.g128sprinttask61.repository.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationRequestService {

  @Autowired
  private ApplicationRequestRepository applicationRequestRepository;

  public List<ApplicationRequest> findAll() {
    return applicationRequestRepository.findAll();
  }

  public void create(ApplicationRequest applicationRequest) {
    applicationRequestRepository.save(applicationRequest);
  }

  public List<ApplicationRequest> search(String text) {
    if (text == null || text.isEmpty()) {
      return Collections.emptyList();
    }

    return applicationRequestRepository.searchSql(text);
  }
}
