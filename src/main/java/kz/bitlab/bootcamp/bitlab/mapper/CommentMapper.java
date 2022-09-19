package kz.bitlab.bootcamp.bitlab.mapper;

import kz.bitlab.bootcamp.bitlab.dto.CommentDto;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.model.Comment;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);
    Comment toEntity(CommentDto commentDto);

    List<CommentDto> toDtoList(List<Comment> comments);
    List<Comment> toEntityList(List<CommentDto> commentDtoList);
}
