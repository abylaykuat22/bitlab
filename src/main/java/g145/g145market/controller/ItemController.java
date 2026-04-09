package g145.g145market.controller;

import g145.g145market.dto.ItemCreateDto;
import g145.g145market.dto.ItemResponse;
import g145.g145market.repository.ItemRepository;
import g145.g145market.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ItemRepository itemRepository;
    @GetMapping
    public List<ItemResponse> getAllItem(){
        List<ItemResponse> itemResponse = itemService.getItem();
        return itemResponse;
    }
    @PostMapping
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemCreateDto dto){
        return ResponseEntity.status(201).body(itemService.addItem(dto));
    }
//    @PutMapping
//    public ResponseEntity<ItemResponse> updateItem(@RequestBody ItemCreateDto dto){
//        return ResponseEntity.status(201).body(itemService.updateItem(dto));
//    }


}
