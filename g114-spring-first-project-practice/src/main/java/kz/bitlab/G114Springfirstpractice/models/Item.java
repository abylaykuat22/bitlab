package kz.bitlab.G114Springfirstpractice.models;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kz.bitlab.G114Springfirstpractice.enums.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "i_name", columnDefinition = "VARCHAR(30)", nullable = false)
  private String name;
  @Column(name = "i_description", columnDefinition = "TEXT")
  private String description;
  private Double price;
  private Integer amount;
  private String country;

  @Enumerated(EnumType.STRING)
  private ItemStatus itemStatus;
}
