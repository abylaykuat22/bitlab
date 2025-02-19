package com.example.g130migrationpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemRequest {

    private String name;
    private Integer price;
    private Integer quantity;
    private Long manufacturerId;
}
