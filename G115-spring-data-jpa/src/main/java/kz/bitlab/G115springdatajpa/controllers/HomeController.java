package kz.bitlab.G115springdatajpa.controllers;

import java.util.List;
import kz.bitlab.G115springdatajpa.models.Item;
import kz.bitlab.G115springdatajpa.repositories.ItemRepository;
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
  private ItemRepository itemRepository;

  @GetMapping("/")
  public String homePage(Model model) {
    List<Item> items = itemRepository.findAll();
    model.addAttribute("tovary", items);
    return "home";
  }

  @GetMapping("/details/{id}")
  public String itemDetails(@PathVariable Long id, Model model) {
    Item item = itemRepository.findById(id).orElse(null);
    model.addAttribute("tovar", item);
    return "details";
  }

  @PostMapping("/add-item")
  public String addItem(Item item) {
    itemRepository.save(item);
    return "redirect:/";
  }

  @PostMapping("/edit-item")
  public String editItem(Item item) {
    itemRepository.save(item);
    return "redirect:/";
  }

  @PostMapping("/delete-item/{id}")
  public String deleteItem(@PathVariable Long id) {
    itemRepository.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/search")
  public String search(@RequestParam(defaultValue = "") String search, Model model) {
    List<Item> items = itemRepository.findItem(search);
    model.addAttribute("tovary", items);
    return "home";
  }
}
