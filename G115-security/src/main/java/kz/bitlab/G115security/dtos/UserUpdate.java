package kz.bitlab.G115security.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdate {
  private Long id;
  private String currentPassword;
  private String newPassword;
  private String reNewPassword;
}
