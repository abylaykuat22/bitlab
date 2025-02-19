package com.example.g130migrationpractice.service;

import com.example.g130migrationpractice.dto.ItemRequest;
import com.example.g130migrationpractice.dto.ItemResponse;

import java.util.List;

public interface ItemService {
    
    List<ItemResponse> getItems();

    ItemResponse getItemById(Long id);

    ItemResponse createItem(ItemRequest itemRequest);
}
