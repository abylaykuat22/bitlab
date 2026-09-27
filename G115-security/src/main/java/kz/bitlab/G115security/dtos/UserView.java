package kz.bitlab.G115security.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserView {
  private Long id;
  private String email;
  private String fullName;
}
