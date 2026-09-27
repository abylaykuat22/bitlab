package kz.bitlab.beans.services.impl;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.beans.models.Item;
import kz.bitlab.beans.services.ItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("itemService")
public class ItemServiceImpl implements ItemService {

  private List<Item> getItems() {
    List<Item> items = new ArrayList<>();
    items.add(new Item(1L, "asd", 12, 23.4));
    items.add(new Item(2L, "zxc", 12, 23.4));
    items.add(new Item(3L, "qwe", 12, 23.4));
    items.add(new Item(4L, "th", 12, 23.4));
    items.add(new Item(5L, "uj", 12, 23.4));
    return items;
  }

  @Override
  public void addItem(Item item) {
    List<Item> items = getItems();
    items.add(item);
    System.out.println("способ первый: " + items);
  }
}
