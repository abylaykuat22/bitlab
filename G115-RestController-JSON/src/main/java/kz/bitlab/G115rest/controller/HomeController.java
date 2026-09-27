package kz.bitlab.G115rest.controller;

import java.util.List;
import kz.bitlab.G115rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
  @Autowired
  private ItemService itemService;
  @GetMapping("/")
  public String homePage() {
    List<String> names = List.of("China", "Misha", "Danik", "Aldik");
    System.out.println(names);
    return "home";
  }

  @GetMapping("/details/{itemId}")
  public String getPicture(@PathVariable Long itemId, Model model) {
    model.addAttribute("item", itemService.getItemById(itemId));
    return "home";
  }
}
