package kz.bitlab.G115rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ITEMS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME", columnDefinition = "VARCHAR(50)", nullable = false)
  @JsonProperty("Name")
  private String name;

  @Column(name = "PRICE", nullable = false)
  private BigDecimal price;

  @Column(name = "CAPTION", columnDefinition = "TEXT")
  private String caption;

  @Column(name = "PICTURE", columnDefinition = "TEXT")
  private String picture;
}
