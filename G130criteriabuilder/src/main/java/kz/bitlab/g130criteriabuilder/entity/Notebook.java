package kz.bitlab.g130criteriabuilder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "NOTEBOOKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @JoinColumn(name = "BRAND_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @JoinColumn(name = "PROCESSOR_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Processor processor;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "MEMORY")
    private String memory;

    @Column(name = "OS")
    private String os;
}
