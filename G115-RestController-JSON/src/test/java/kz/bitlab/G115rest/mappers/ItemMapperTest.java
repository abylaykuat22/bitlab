package kz.bitlab.G115rest.mappers;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import kz.bitlab.G115rest.model.Item;
import org.junit.jupiter.api.Test;

class ItemMapperTest {

  @Test
  void toDto() {
    var item = Item.builder()
        .name("QQQ")
        .price(BigDecimal.valueOf(999))
        .caption("WWW")
        .build();
    var itemDto = ItemMapper.INSTANCE.toDto(item);
    assertNotNull(itemDto.getName(), "itemDto name is null");
    assertNotNull(itemDto.getPrice(), "itemDto price is null");
    assertNotNull(itemDto.getDescription(), "itemDto description is null");
    assertEquals(item.getName(), itemDto.getName());
    assertEquals(item.getPrice(), itemDto.getPrice());
    assertEquals(item.getCaption(), itemDto.getDescription());
  }
}