package bitlab.g111.springsecurity.mappers;

import bitlab.g111.springsecurity.dtos.ItemCreate;
import bitlab.g111.springsecurity.dtos.ItemView;
import bitlab.g111.springsecurity.models.Item;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

  @Mapping(source = "name", target = "itemName")
  @Mapping(source = "price", target = "itemPrice")
  @Mapping(source = "brand", target = "itemBrand")
  @Mapping(source = "brand.name", target = "itemBrand.brandName")
  ItemView toView(Item item);

  Item toEntity(ItemCreate itemCreate);

  List<ItemView> toViewList(List<Item> items);
}
