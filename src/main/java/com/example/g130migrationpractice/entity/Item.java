package com.example.g130migrationpractice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ITEMS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @JoinColumn(name = "MANUFACTURER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country manufacturer;

}
