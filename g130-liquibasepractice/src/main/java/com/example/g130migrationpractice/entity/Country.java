package com.example.g130migrationpractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COUNTRIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;
}
