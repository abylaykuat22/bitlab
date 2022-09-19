package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import liquibase.pro.packaged.L;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService extends UserDetailsService {
    User getUserByEmail(String email);
    User getUserById(Long id);
    User getCurrentUser();
    Picture getCurrentUserPicture();
    List<UserDto> getAllUsers();
    List<PictureDto> getUsersAvatars();
    UserDto getUserDto(Long id);
    Picture addUser(Courier courier);
    User changePassword(Courier courier);
    UserDto checkCodeWord(Courier courier);
    UserDto resetAddNewPassword(Courier courier);
    Picture avatarPicture();
    void deleteUserAvatar();
    Courier getCurrentUserData();
    String addDeleteLike(Long pictureId);
    void updateUser(User user);
}
