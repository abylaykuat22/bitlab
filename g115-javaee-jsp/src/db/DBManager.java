package db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import models.Item;

public class DBManager {
  private static List<Item> items = new ArrayList<>();

  private static Long id = 6L;

  static {
    items.add(new Item(1L, "IPhone X", 200000, 10));
    items.add(new Item(2L, "IPhone 11", 300000, 11));
    items.add(new Item(3L, "Samsung s21", 400000, 21));
    items.add(new Item(4L, "Tesla model Y", 10000000, 5));
    items.add(new Item(5L, "Freezer model W21", 500000, 100));
  }

  public static List<Item> getItems() {
    return items;
  }

  public static void addItem(String name, double price, int amount) {
    Item item = new Item();
    item.setName(name);
    item.setPrice(price);
    item.setAmount(amount);
    item.setId(id);
    items.add(item);
    id++;
  }

  public static Item getItemById(Long id) {
    return items.stream()
        .filter(item -> Objects.equals(item.getId(), id))
        .findFirst()
        .orElse(null);

  }
}
