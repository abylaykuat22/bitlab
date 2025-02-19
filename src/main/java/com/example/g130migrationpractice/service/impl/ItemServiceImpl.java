package com.example.g130migrationpractice.service.impl;

import com.example.g130migrationpractice.dto.ItemRequest;
import com.example.g130migrationpractice.dto.ItemResponse;
import com.example.g130migrationpractice.entity.Country;
import com.example.g130migrationpractice.entity.Item;
import com.example.g130migrationpractice.exception.EntityNotFoundException;
import com.example.g130migrationpractice.exception.IncorrectRequestException;
import com.example.g130migrationpractice.mapper.ItemMapper;
import com.example.g130migrationpractice.repository.ItemRepository;
import com.example.g130migrationpractice.service.CountryService;
import com.example.g130migrationpractice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CountryService countryService;

    @Override
    public List<ItemResponse> getItems() {
        List<Item> items = itemRepository.findAll();
        return ItemMapper.INSTANCE.toDtoList(items);
    }

    @Override
    public ItemResponse getItemById(Long id) {
        return itemRepository.findById(id)
                .map(item -> ItemMapper.INSTANCE.toDto(item))
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
    }

    @Override
    public ItemResponse createItem(ItemRequest itemRequest) {
        try {
            Country country = countryService.getCountryById(itemRequest.getManufacturerId());
            Item item = ItemMapper.INSTANCE.toEntity(itemRequest);
            item.setManufacturer(country);
            Item savedItem = itemRepository.save(item);
            return ItemMapper.INSTANCE.toDto(savedItem);
        } catch (EntityNotFoundException e) {
            throw new IncorrectRequestException("Country not found");
        } catch (Exception e) {
            throw e;
        }
    }
}
