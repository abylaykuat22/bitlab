package kz.bitlab.G114crm.services;

import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.repositories.ApplicationRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ApplicationRequestService {
    @Autowired
    private ApplicationRequestRepo applicationRequestRepo;

    public List<ApplicationRequest> getAppReqs() {
        List<ApplicationRequest> appReqList = applicationRequestRepo.findAll();
        return appReqList.stream()
//                .filter(appReq -> appReq.isHandled())
                .sorted(Comparator.comparing(ApplicationRequest::getCourseName))
                .toList();
    }

    public ApplicationRequest getAppReqById(Long id) {
        return applicationRequestRepo.findById(id).orElse(null);
    }

    public void addAppReq(ApplicationRequest appReq) {
        applicationRequestRepo.save(appReq);
    }

    public void updateHandled(Long id) {
        ApplicationRequest req = getAppReqById(id);
        req.setHandled(true);
        applicationRequestRepo.save(req);
    }

    public void editAppReq(ApplicationRequest appReq) {
        applicationRequestRepo.save(appReq);
    }

    public void deleteAppReqById(Long id) {
        applicationRequestRepo.deleteById(id);
    }
}
