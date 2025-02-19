package com.example.g130migrationpractice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "DTO для получения данных о товаре")
public class ItemResponse {

    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    private String manufacturer;
}
