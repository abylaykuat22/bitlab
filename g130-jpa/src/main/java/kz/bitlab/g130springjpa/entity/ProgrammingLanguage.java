package kz.bitlab.g130springjpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DEVELOPERS_PROGRAMMING_LANGUAGE",
            inverseJoinColumns = @JoinColumn(name = "DEVELOPER_ID"),
            joinColumns = @JoinColumn(name = "PROGRAMMING_LANGUAGE_ID"))
    private List<Developer> developers;
}
