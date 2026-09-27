package kz.bitlab.G115sprinttask61.service;

import java.util.List;
import kz.bitlab.G115sprinttask61.entity.ApplicationRequest;
import kz.bitlab.G115sprinttask61.exception.AppReqNotFoundException;
import kz.bitlab.G115sprinttask61.repository.ApplicationRequestRepository;
import kz.bitlab.G115sprinttask61.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationRequestService {
  private final ApplicationRequestRepository appReqRepository;
  private final CommentRepository commentRepository;

  public void addAppReq(ApplicationRequest appReq) {
    commentRepository.save(appReq.getComment());
    appReq.setHandled(false);
    appReqRepository.save(appReq);
  }

  public List<ApplicationRequest> getAppRequests() {
    return appReqRepository.findAll();
  }

  public ApplicationRequest getAppReqById(Long id) {
    return appReqRepository.findById(id)
        .orElseThrow(() -> new AppReqNotFoundException("Application Request not found!"));
  }

  public void editAppReq(ApplicationRequest appReq) {
    commentRepository.save(appReq.getComment());
    appReq.setHandled(true);
    appReqRepository.save(appReq);
  }

  public void deleteAppReqById(Long id) {
    appReqRepository.deleteById(id);
  }
}
