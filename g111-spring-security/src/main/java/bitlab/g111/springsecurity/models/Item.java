package bitlab.g111.springsecurity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends BaseEntity {

  private String name;
  private String description;
  private double price;
  private String key;
  @ManyToOne
  private Brand brand;
}
