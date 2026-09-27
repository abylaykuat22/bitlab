package kz.bitlab.g130springfirsttask.controller;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import kz.bitlab.g130springfirsttask.db.DbManager;
import kz.bitlab.g130springfirsttask.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("items", DbManager.getItems());
    return "home-page";
  }

  @PostMapping("/item/add")
  public String addItem(@RequestParam String name, @RequestParam String description,
      @RequestParam Double price,
      Reader reader) {
    Item item = new Item();
    item.setName(name);
    item.setDescription(description);
    item.setPrice(price);
    DbManager.addItem(item);
    return "redirect:/";
  }
}
