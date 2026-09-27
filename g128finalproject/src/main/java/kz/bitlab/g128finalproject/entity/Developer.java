package kz.bitlab.g128finalproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DEVELOPERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SALARY")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "PROGRAMMING_LANGUAGES_ID")
    private ProgrammingLanguage programmingLanguage;

    @ManyToOne
    @JoinColumn(name = "WORKING_FORMATS_ID")
    private WorkingFormat workingFormat;

}
