package kz.bitlab.g130springbean.controller;

import kz.bitlab.g130springbean.db.DBManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HomeController {

    private final DBManager dbManager;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("tasks", dbManager.getTasks());
        return "home";
    }

    @PostMapping("/tasks/add")
    public String addTasks(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String deadlineDate
    ) {
        dbManager.addTask(name, description, deadlineDate);
        return "redirect:/";
    }
}
