package kz.bitlab.g128finalproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PROGRAMMING_LANGUAGES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}
