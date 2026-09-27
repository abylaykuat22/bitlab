package kz.bitlab.bootcamp.bitlab.mapper;

import kz.bitlab.bootcamp.bitlab.dto.NewsDto;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.model.News;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsDto toDto(News news);
    News toEntity(NewsDto newsDto);

    List<NewsDto> toDtoList(List<News> news);
    List<News> toEntityList(List<NewsDto> newsDtoList);
}
