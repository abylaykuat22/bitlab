package kz.bitlab.g139springtask.controller;

import kz.bitlab.g139springtask.model.ApplicationRequest;
import kz.bitlab.g139springtask.service.ApplicationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ApplicationRequestController {

    private final ApplicationRequestService applicationRequestService;

    // TODO: пример
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("applications", applicationRequestService.applicationRequests());
        return "home";
    }

    // TODO: пример
    @PostMapping("/applications/add")
    public String add() {
        return "home";
    }


}
