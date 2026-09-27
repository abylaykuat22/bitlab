package bitlab.g111.springsecurity.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemView {

  private Long id;
  private String itemName;
  private double itemPrice;
  private BrandDto itemBrand;
}
