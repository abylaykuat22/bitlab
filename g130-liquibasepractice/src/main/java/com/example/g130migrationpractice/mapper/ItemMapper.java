package com.example.g130migrationpractice.mapper;

import com.example.g130migrationpractice.dto.ItemRequest;
import com.example.g130migrationpractice.dto.ItemResponse;
import com.example.g130migrationpractice.entity.Country;
import com.example.g130migrationpractice.entity.Item;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true))
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

//    @Mapping(source = "dto.name", target = "name")
//    @Mapping(source = "dto.price", target = "price")
//    @Mapping(source = "dto.quantity", target = "quantity")
//    @Mapping(source = "manufacturer", target = "manufacturer")
//    Item toEntity(ItemRequest dto, Country manufacturer);

    Item toEntity(ItemRequest dto);

    @Mapping(source = "manufacturer.name", target = "manufacturer")
    ItemResponse toDto(Item entity);

    List<ItemResponse> toDtoList(List<Item> entities);
}
