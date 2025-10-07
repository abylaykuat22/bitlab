package kz.bitlab.g139jpa.controller;

import kz.bitlab.g139jpa.entity.Item;
import kz.bitlab.g139jpa.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/")
    public String items(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @PostMapping("/items/add")
    public String addItem(Item item) {
        itemService.addItem(item);
        return "redirect:/";
    }

    @GetMapping("/items/{id}")
    public String getItemById(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-details";
    }

    @PostMapping("/items/edit")
    public String editItem(Item item) {
        itemService.editItem(item);
        return "redirect:/";
    }

    @PostMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/";
    }
}
