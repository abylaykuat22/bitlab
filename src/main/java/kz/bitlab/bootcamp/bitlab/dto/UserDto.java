package kz.bitlab.bootcamp.bitlab.dto;

import kz.bitlab.bootcamp.bitlab.model.Picture;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String fullName;
    private String birthdate;
    private String gender;
    private String statusAvatar;
}
