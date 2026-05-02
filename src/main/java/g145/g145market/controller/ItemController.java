package g145.g145market.controller;

import g145.g145market.dto.ItemCreateDto;
import g145.g145market.dto.ItemResponse;
import g145.g145market.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@Tag(name = "Item management", description = "Управление товарами")
public class ItemController {
    private final ItemService itemService;

    @Operation(summary = "Получить список всех товаров", description = "Получить все товары из Postgres и преобразовать в DTO")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Данные получены успешно"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера"
            )
    })
    @GetMapping
    public List<ItemResponse> getAllItem() {
        return itemService.getItem();
    }

    @Operation(summary = "Добавить товар", description = "Считать DTO преобразовать в сущность и сохранить в базу данных")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Товар добавлен успешно"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера"
            )
    })
    @PreAuthorize("hasAnyRole('MANAGER')")
    @PostMapping
    public ResponseEntity<ItemResponse> addItem(@Valid @RequestBody ItemCreateDto dto) {
        return ResponseEntity.status(201).body(itemService.addItem(dto));
    }

    @Operation(summary = "Обновить товар", description = "Считать ДТО преобразовать в сущность и обновить в базе данных")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Данные получены успешно"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар не найден"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ItemResponse> updateItem(@PathVariable Long id,
                                                   @RequestBody ItemCreateDto dto) {
        return ResponseEntity.status(200).body(itemService.updateItem(id, dto));
    }

    @Operation(summary = "Удалить товар")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Товар удален успешно"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Товар не найден"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Ошибка сервера"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(204).build();
    }
}
