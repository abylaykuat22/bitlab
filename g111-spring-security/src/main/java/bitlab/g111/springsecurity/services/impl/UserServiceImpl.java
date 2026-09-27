package bitlab.g111.springsecurity.services.impl;

import bitlab.g111.springsecurity.models.Role;
import bitlab.g111.springsecurity.models.User;
import bitlab.g111.springsecurity.repositories.RoleRepository;
import bitlab.g111.springsecurity.repositories.UserRepository;
import bitlab.g111.springsecurity.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found!");
    }
    return user;
  }

  @Override
  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      return (User) authentication.getPrincipal();
    }
    return null;
  }

  @Override
  public String addUser(String email, String password, String rePassword, String fullName) {
    String redirectValue = "signup?erroremail";
    User user = userRepository.findByEmail(email);
    if (user == null) {
      redirectValue = "signup?errorpasswords";
      if (password.equals(rePassword)) {
        user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(fullName);

        Role role = roleRepository.getUserRole();
        List<Role> roles = List.of(role);
        user.setRoles(roles);

        userRepository.save(user);
        redirectValue = "signup?success";
      }
    }
    return redirectValue;
  }

  @Override
  public String updatePassword(String currentPassword, String newPassword, String reNewPassword) {
    String redirectValue = "updatepassword?errorcurrentpassword";
    User currentUser = getCurrentUser();
    if (passwordEncoder.matches(currentPassword, currentUser.getPassword())) {
      redirectValue = "updatepassword?errorpasswords";
      if (newPassword.equals(reNewPassword)) {
        currentUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(currentUser);
        redirectValue = "updatepassword?success";
      }
    }
    return redirectValue;
  }
}
