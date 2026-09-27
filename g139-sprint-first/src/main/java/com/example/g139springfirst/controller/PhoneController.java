package com.example.g139springfirst.controller;

import com.example.g139springfirst.model.Phone;
import com.example.g139springfirst.repository.PhoneRepository;
import com.example.g139springfirst.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("/phones")
    public String phones(Model model) {
        model.addAttribute("phones", phoneService.getPhones());
        return "phones";
    }

    @PostMapping("/phones/add")
    public String addPhone(Phone phone) {
        phoneService.addPhone(phone);
        return "redirect:/phones";
    }
}
//ffffff
// sss
