package com.example.g139springfirst.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    private Long id;
    private String name;
    private int age;
    private double gpa;
    private int point;
    private String pointMark;
}
