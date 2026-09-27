package kz.bitlab.G114Springfirstpractice.controllers;

import java.util.List;
import kz.bitlab.G114Springfirstpractice.enums.ItemStatus;
import kz.bitlab.G114Springfirstpractice.models.Item;
import kz.bitlab.G114Springfirstpractice.repositories.ItemRepository;
import kz.bitlab.G114Springfirstpractice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  private ItemService itemService;
  @Autowired
  private ItemRepository itemRepository;

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("statuses", ItemStatus.values());
    model.addAttribute("zattar", itemService.getItems());
    return "home";
  }

  @GetMapping("/search")
  public String homePage(@RequestParam String search, Model model) {
    model.addAttribute("statuses", ItemStatus.values());
    model.addAttribute("zattar", itemRepository.search(search));
    return "home";
  }

  @GetMapping("details/{id}")
  public String detailsPage(@PathVariable Long id, Model model) {
    var countries = List.of("CHINA", "USA", "Finland", "Japan", "Korea", "France", "Italy");

    model.addAttribute("statuses", ItemStatus.values());
    model.addAttribute("countries", countries);
    model.addAttribute("item", itemService.getItemById(id));
    return "details";
  }

  @PostMapping("add-item")
  public String addItem(Item item) {
    itemService.addItem(item);
    return "redirect:/";
  }

  @PostMapping("edit-item")
  public String editItemById(Item item) {
    itemService.editItem(item);
    return "redirect:/details/" + item.getId();
  }

  @PostMapping("delete-item/{id}")
  public String deleteItem(@PathVariable Long id) {
    itemService.deleteItemById(id);
    return "redirect:/";
  }
}
