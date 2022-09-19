package kz.bitlab.bootcamp.bitlab.mapper;

import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PictureMapper {
    PictureDto toDto(Picture picture);
    Picture toEntity(PictureDto pictureDto);

    List<PictureDto> toDtoList(List<Picture> pictures);
    List<Picture> toEntityList(List<PictureDto> pictureDtoList);
}
