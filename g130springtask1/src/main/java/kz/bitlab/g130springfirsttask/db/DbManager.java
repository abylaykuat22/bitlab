package kz.bitlab.g130springfirsttask.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.g130springfirsttask.entity.Item;
import lombok.Getter;

public class DbManager {

  @Getter
  private static List<Item> items = new ArrayList<>(
      List.of(
          new Item(1L, "Mac Book Pro", "8 GB RAM SSD INTEL CORE i7", 1199.99),
          new Item(2L, "Mac Book Pro", "16 GB RAM SSD INTEL CORE i7", 1499.99),
          new Item(3L, "Mac Book Pro", "16 GB RAM SSD INTEL CORE i8", 1699.99),
          new Item(4L, "ASUS Tuf Gaming", "16 GB RAM SSD INTEL CORE i7", 1299.99),
          new Item(5L, "HP Laser Pro", "8 GB RAM SSD INTEL CORE i7", 1099.99),
          new Item(6L, "Lenovo Legion", "8 GB RAM SSD INTEL CORE i7", 999.99)
      )
  );

  private static Long id = 7L;

  public static void addItem(Item item) {
    if (item != null) {
      item.setId(id);
      items.add(item);
      id++;
    }
  }

}
