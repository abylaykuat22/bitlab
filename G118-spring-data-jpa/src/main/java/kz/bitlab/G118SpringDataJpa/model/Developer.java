package kz.bitlab.G118SpringDataJpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

  @Column(name = "EMAIL", unique = true, nullable = false)
  private String email;

  @Column(name = "FULL_NAME", nullable = false)
  private String fullName;

  @Column(name = "AGE")
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "PROGRAMMING_LANGUAGE_ID")
  private ProgrammingLanguage programmingLanguage;

  @OneToOne
  private Position position;

  @ManyToMany
  private List<Company> companies;
}
