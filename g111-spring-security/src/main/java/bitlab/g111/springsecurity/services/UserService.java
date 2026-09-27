package bitlab.g111.springsecurity.services;

import bitlab.g111.springsecurity.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  User getCurrentUser();

  String addUser(String email, String password, String rePassword, String fullName);

  String updatePassword(String currentPassword, String newPassword, String reNewPassword);
}
