package bitlab.g111.springsecurity.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Brand extends BaseEntity {

  private String name;
  private String secretKey;
  private String secretCode;
}
