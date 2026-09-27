package kz.bitlab.g139rest.mapper;

import kz.bitlab.g139rest.dto.UserCreateDto;
import kz.bitlab.g139rest.dto.UserResponseDto;
import kz.bitlab.g139rest.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto toDto(User user);

    @Mapping(target = "passwordHash", source = "password")
    User toEntity(UserCreateDto dto);
}
