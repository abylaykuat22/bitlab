package g145.g145market.mapper;

import g145.g145market.dto.CategoryCreateDto;
import g145.g145market.dto.CategoryResponse;
import g145.g145market.dto.UserResponse;
import g145.g145market.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    @Mapping(source = "namekz", target = "nameKz")
    Category toEntity(CategoryCreateDto createDto);
    CategoryResponse toResponse(Category category);
}
