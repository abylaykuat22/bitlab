package com.example.g139springfirst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    private Long id;
    private String name;
    private int year;
    private double price;
    private String color;
}
