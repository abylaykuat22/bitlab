package kz.bitlab.bootcamp.bitlab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PictureDto {
    private Long id;
    private String picture;
    private String rolePicture;
    private UserDto user;
}
