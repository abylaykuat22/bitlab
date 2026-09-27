package kz.bitlab.G115security.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreate {
  private String userEmail;
  private String password;
  private String rePassword;
  private String fullName;
}
