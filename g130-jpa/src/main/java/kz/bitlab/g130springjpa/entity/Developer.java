package kz.bitlab.g130springjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "FULL_NAME", columnDefinition = "VARCHAR(150)")
    private String fullName;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "AGE")
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BIRTH_COUNTRY_ID")
    private Country birthCountry;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DEVELOPERS_PROGRAMMING_LANGUAGE",
            joinColumns = @JoinColumn(name = "DEVELOPER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROGRAMMING_LANGUAGE_ID"))
    private List<ProgrammingLanguage> programmingLanguages;
}
