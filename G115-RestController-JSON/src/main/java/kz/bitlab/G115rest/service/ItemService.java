package kz.bitlab.G115rest.service;

import java.util.Arrays;
import java.util.List;
import kz.bitlab.G115rest.exceptions.ItemNotFoundException;
import kz.bitlab.G115rest.model.Item;
import kz.bitlab.G115rest.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {
  private final ItemRepository itemRepository;

  public List<Item> getItems() {
    log.info("ЭТО СЕРВИС ДЛЯ ОБЪЕКТА АЙТЕМ");
    return itemRepository.findAll().stream()
        .filter(item -> item.getCaption() != null && !item.getCaption().isBlank())
        .toList();
  }

  /**
   * Метод для добавления нового айтема.
   *
   * @param item новый продукт
   * @return сохраенный продукт
   */
  public Item addItem(Item item) {
    setAnotherCaption("COUNTRY KAZAKHSTAN", "123", "asdasd", "123213", "zxc");
    return itemRepository.save(item);
  }

  public void setAnotherCaption(String... text) {
    System.out.println(Arrays.toString(text));
  }

  public Item editItem(Item item) {
    return itemRepository.save(item);
  }

  public void deleteItemById(Long id) {
    itemRepository.deleteById(id);
  }

  public Item getItemById(Long id) {
    return itemRepository.findById(id)
        .orElseThrow(() -> new ItemNotFoundException("ITEM NOT FOUND"));
  }

  public List<Item> getFilteredItems(String search) {
    return itemRepository.findFilteredItems(search);
  }

  public void addPicture(MultipartFile picture, Long itemId) {
    var item = getItemById(itemId);
    item.setPicture(picture.getOriginalFilename());
    itemRepository.save(item);
  }
}
