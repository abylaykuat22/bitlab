package kz.bitlab.G114springfirstapp.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kz.bitlab.G114springfirstapp.models.Item;

public class DBManager {
  public static List<Item> items = new ArrayList<>();

  private static Long id = 6L;

  static {
    items.add(new Item(1L, "IPhone 11", "256 gb", "Phone", 200000));
    items.add(new Item(2L, "Samsung s21", "512 gb", "Phone", 300000));
    items.add(new Item(3L, "Tesla Model Y", "unknown", "Car", 20000000));
    items.add(new Item(4L, "SpaceX Rocket Model X", "", "Rocket", 200000000));
    items.add(new Item(5L, "Freezer", "secret info", "Freezer", 900000));
  }

  public static List<Item> getItems() {
    return items;
  }

  public static void addItem(Item item) {
    item.setId(id);
    id++;
    items.add(item);
  }

  public static Item getItemById(Long id) {
    return items.stream()
        .filter(item -> Objects.equals(item.getId(), id))
        .findFirst()
        .orElse(null);
  }

  public static void deleteItemById(Long id) {
    items.removeIf(item -> Objects.equals(item.getId(), id));
  }
}
