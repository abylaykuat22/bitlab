package kz.bitlab.g130criteriabuilder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROCESSOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "POWER", nullable = false)
    private String power;

    @Column(name = "CORES_AMOUNT")
    private Short coresAmount;
}
