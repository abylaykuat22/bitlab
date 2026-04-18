package g145.g145market.mapper;

import g145.g145market.dto.UserCreateDto;
import g145.g145market.dto.UserResponse;
import g145.g145market.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
//        builder = @Builder(disableBuilder = true), переключение из builder в getter/setter
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "fullName")
    User toEntity(UserCreateDto dto);

    @Mapping(source = "birthdate", target = "dateOfBirth")
    @Mapping(source = "phoneNumber", target = "number")
    UserResponse toDto(User user);
}
