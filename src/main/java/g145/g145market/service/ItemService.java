package g145.g145market.service;

import g145.g145market.dto.ItemCreateDto;
import g145.g145market.dto.ItemResponse;
import g145.g145market.entity.Item;
import g145.g145market.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemResponse addItem(@Valid ItemCreateDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Item item = Item.builder()
                .name_kz(dto.getName_kz())
                .name_ru(dto.getName_ru())
                .name_en(dto.getName_en())
                .price(dto.getPrice())
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .made_in(dto.getMade_in())
                .build();
        Item savedItem = itemRepository.save(item);


        ItemResponse itemResponse = ItemResponse.builder()
                .id(savedItem.getId())
                .name_kz(savedItem.getName_kz())
                .name_ru(savedItem.getName_ru())
                .name_en(savedItem.getName_en())
                .price(savedItem.getPrice())
                .amount(savedItem.getAmount())
                .status(savedItem.getStatus())
                .made_in(savedItem.getMade_in())
                .createdAt(savedItem.getCreatedAt().toString())
                .build();
        return itemResponse;
    }

    public  List<ItemResponse> getItem() {
        return itemRepository.findAll().stream().map(
                item->ItemResponse.builder()
                        .name_kz(item.getName_kz())
                        .name_ru(item.getName_ru())
                        .name_en(item.getName_en())
                        .price(item.getPrice())
                        .amount(item.getAmount())
                        .status(item.getStatus())
                        .made_in(item.getMade_in())
                        .createdAt(item.getCreatedAt().toString())
                        .build()
        ).toList();
    }
//    public ItemResponse updateItem(ItemCreateDto dto) {
//        Long dtoId = item.getId();
//        Item changedItem = itemRepository.findAllById();
//        return null;
//    }

}
