package kz.bitlab.G114ajax.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ACADEMIES")
@Getter
@Setter
@ToString
public class Academy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", columnDefinition = "VARCHAR(50)", unique = true)
  private String name;

  @Column(name = "RATING")
  private Double rating;

  @Column(name = "COURSE", columnDefinition = "VARCHAR(30)")
  private String course;

  @Column(name = "FULL_ADDRESS")
  private String fullAddress;

  @ManyToOne
  @JoinColumn(name = "CITY_ID")
  private City city;
}
