package kz.bitlab.G115security.mappers;

import java.util.List;
import kz.bitlab.G115security.dtos.UserCreate;
import kz.bitlab.G115security.dtos.UserView;
import kz.bitlab.G115security.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserView toView(User entity);

  @Mapping(source = "userEmail", target = "email")
  User toEntity(UserCreate dto);

  List<UserView> toViewList(List<User> entityList);
}
