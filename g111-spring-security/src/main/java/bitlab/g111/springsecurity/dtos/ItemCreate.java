package bitlab.g111.springsecurity.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreate {

  private String name;
  private String description;
  private double price;
  private BrandDto brand;
}
