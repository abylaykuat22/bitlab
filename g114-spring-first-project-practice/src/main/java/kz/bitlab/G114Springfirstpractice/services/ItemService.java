package kz.bitlab.G114Springfirstpractice.services;

import java.util.List;
import kz.bitlab.G114Springfirstpractice.models.Item;
import kz.bitlab.G114Springfirstpractice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

  @Autowired
  private ItemRepository itemRepository;

  public List<Item> getItems() {
    return itemRepository.findAll();
  }

  public Item getItemById(Long id) {
    return itemRepository.findById(id).orElse(null);
  }

  public void addItem(Item item) {
    itemRepository.save(item);
  }

  public void editItem(Item item) {
    itemRepository.save(item);
  }

  public void deleteItemById(Long id) {
    itemRepository.deleteById(id);
  }
}
