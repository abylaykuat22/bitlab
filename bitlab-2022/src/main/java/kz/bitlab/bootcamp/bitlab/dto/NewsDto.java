package kz.bitlab.bootcamp.bitlab.dto;

import kz.bitlab.bootcamp.bitlab.model.Picture;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class NewsDto {
    private Long id;
    private UserDto user;
    private String description;
    private List<PictureDto> pictures;
    private Date createdAt;
    private Long pictureId;
    private int amountLikes;
}
