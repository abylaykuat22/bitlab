package g145.g145market.controller;

import g145.g145market.dto.ItemCreateDto;
import g145.g145market.dto.ItemResponse;
import g145.g145market.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private ItemService itemService;
    @GetMapping
    public List<ItemResponse> getAllItem(){
        return null;
    }
    @PostMapping
    public ResponseEntity<ItemResponse> addItem(@RequestBody ItemCreateDto dto){
        return ResponseEntity.status(201).body(itemService.addItem(dto));
    }
}
