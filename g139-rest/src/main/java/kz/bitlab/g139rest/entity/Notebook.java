package kz.bitlab.g139rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NOTEBOOKS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "MEMORY")
    private String memory;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "OS")
    private String os;

    @JoinColumn(name = "BRAND_ID")
    @ManyToOne
    private Brand brand;
}
