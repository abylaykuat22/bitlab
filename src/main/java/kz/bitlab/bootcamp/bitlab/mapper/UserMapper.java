package kz.bitlab.bootcamp.bitlab.mapper;

import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);
    List<User> toEntityList(List<UserDto> userDtoList);
}
