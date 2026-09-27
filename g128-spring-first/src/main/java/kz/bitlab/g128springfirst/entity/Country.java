package kz.bitlab.g128springfirst.entity;

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
@Table(name = "COUNTRIES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(100)")
  private String name;

  @Column(name = "CODE", nullable = false, unique = true, columnDefinition = "VARCHAR(3)")
  private String code;

  @Column(name = "MAINLAND")
  private String mainland;

  @Column(name = "WORLD_PART")
  private String worldPart;
}
