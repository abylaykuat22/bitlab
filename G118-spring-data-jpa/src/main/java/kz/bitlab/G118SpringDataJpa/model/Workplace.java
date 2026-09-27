package kz.bitlab.G118SpringDataJpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "WORKPLACES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workplace {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "APPLICATION_AREA", columnDefinition = "VARCHAR(20)")
  private String applicationArea;

  @Column(name = "CAPTION", columnDefinition = "TEXT")
  private String caption;

  @ManyToOne
  @JoinColumn(name = "PROGRAMMING_LANGUAGE_ID")
  private ProgrammingLanguage programmingLanguage;
}
