package com.example.g130migrationpractice.controller;

import com.example.g130migrationpractice.dto.ItemRequest;
import com.example.g130migrationpractice.dto.ItemResponse;
import com.example.g130migrationpractice.exception.EntityNotFoundException;
import com.example.g130migrationpractice.exception.IncorrectRequestException;
import com.example.g130migrationpractice.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    @Operation(summary = "Получение списка товаров", description = "Возвращает список всех товаров")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Ошибка при получении товаров"),
            @ApiResponse(responseCode = "200", description = "Товары успешно получены", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ItemResponse.class))
            })
    })
    public ResponseEntity<List<ItemResponse>> getItems() {
        try {
            List<ItemResponse> items = itemService.getItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            log.error("Error while getting items {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение товара по ID", description = "Возвращает товар или ошибку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Товар не найден"),
            @ApiResponse(responseCode = "200", description = "Товары успешно получены", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ItemResponse.class))
            })
    })
    public ResponseEntity<ItemResponse> getItem(@PathVariable Long id) {
        try {
            ItemResponse item = itemService.getItemById(id);
            return ResponseEntity.ok(item);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error("Error while getting item by id {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @Operation(summary = "Добавление товара", description = "Добавляет товар")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Неверный запрос"),
            @ApiResponse(responseCode = "201", description = "Товар успешно добавлен", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ItemResponse.class))
            })
    })
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest itemRequest) {
        try {
            ItemResponse itemResponse = itemService.createItem(itemRequest);
            return new ResponseEntity<>(itemResponse, HttpStatus.CREATED);
        } catch (IncorrectRequestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error while creating item {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
