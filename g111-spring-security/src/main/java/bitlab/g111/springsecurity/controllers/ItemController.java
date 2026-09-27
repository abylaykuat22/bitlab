package bitlab.g111.springsecurity.controllers;

import bitlab.g111.springsecurity.dtos.ItemCreate;
import bitlab.g111.springsecurity.dtos.ItemUpdate;
import bitlab.g111.springsecurity.dtos.ItemView;
import bitlab.g111.springsecurity.repositories.ItemRepository;
import bitlab.g111.springsecurity.services.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private ItemService itemService;

  @GetMapping
  public List<ItemView> getItems() {
    return itemService.getItems();
  }

  @GetMapping("{id}")
  public ItemView getItem(@PathVariable Long id) {
    return itemService.getItem(id);
  }

  @PostMapping
  public ItemView addItem(@RequestBody ItemCreate itemCreate) {
    return itemService.addItem(itemCreate);
  }

  @PutMapping
  public ItemView updateItem(@RequestBody ItemUpdate itemUpdate) {
    return itemService.updateItem(itemUpdate);
  }

  @DeleteMapping("{id}")
  public void deleteItem(@PathVariable Long id) {
    itemRepository.deleteById(id);
  }
}
