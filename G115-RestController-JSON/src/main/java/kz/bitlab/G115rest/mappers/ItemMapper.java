package kz.bitlab.G115rest.mappers;

import kz.bitlab.G115rest.dtos.ItemDto;
import kz.bitlab.G115rest.model.Item;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ItemMapper {
  ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

  @Mapping(target = "description", source = "caption")
  ItemDto toDto(Item item);
}
