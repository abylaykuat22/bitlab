package kz.bitlab.G115springfirstproject.db;

import static kz.bitlab.G115springfirstproject.enums.ItemStatus.IN_SHOP;
import static kz.bitlab.G115springfirstproject.enums.ItemStatus.IN_STOCK;
import static kz.bitlab.G115springfirstproject.enums.ItemStatus.ON_DELIVERY;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.G115springfirstproject.models.Item;
import lombok.Getter;

public class DBManager {
  @Getter
  private static List<Item> items = new ArrayList<>();
  private static Long id = 6L;

  static {
    items.add(new Item(1L, "HP", "512gb ssd", 350000, IN_SHOP));
    items.add(new Item(2L, "MACBOOK M2", "512gb ssd", 1000000, IN_STOCK));
    items.add(new Item(3L, "Samsung Galaxy s22", "256gb ssd", 600000, ON_DELIVERY));
    items.add(new Item(4L, "IPhone X", "256gb ssd", 600000, IN_STOCK));
    Item item = Item.builder()
        .id(5L)
        .name("HP")
        .description("asdasd")
        .price(123123)
        .status(ON_DELIVERY)
        .build();
    items.add(item);
  }

  public static void addItem(Item item) {
    item.setId(id);
    id++;
    items.add(item);
  }
}
