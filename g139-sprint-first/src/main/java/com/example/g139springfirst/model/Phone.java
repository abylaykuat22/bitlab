package com.example.g139springfirst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private Double price;
    private String memory;
}
