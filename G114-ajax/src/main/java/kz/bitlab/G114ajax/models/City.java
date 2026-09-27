package kz.bitlab.G114ajax.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CITIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", columnDefinition = "VARCHAR(50)", nullable = false)
  private String name;

  @Column(name = "CODE", columnDefinition = "VARCHAR(3)")
  private String code;
}
