package kz.bitlab.G115rest.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import kz.bitlab.G115rest.exceptions.ItemNotFoundException;
import kz.bitlab.G115rest.exceptions.ItemValueException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ItemServiceTest {

  @Autowired
  private ItemService itemService;

  @Test
  void getItems() {
    var items = itemService.getItems();
    items.forEach(item -> {
      if (item.getCaption() == null || item.getCaption().isBlank()) {
        assertThrows(ItemValueException.class, () -> itemService.getItems(),
            "Caption is null or blank");
      }
    });
  }

  @Test
  void getItemById() {
    var item = itemService.getItemById(8L);
    assertNotNull(item.getId());
    assertNotNull(item.getName());
    assertNotNull(item.getPrice());
    assertTrue(item.getPrice().compareTo(BigDecimal.ZERO) > 0);
  }
}