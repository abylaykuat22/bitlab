package kz.bitlab.G115security.service;

import java.util.List;
import kz.bitlab.G115security.dtos.UserCreate;
import kz.bitlab.G115security.dtos.UserUpdate;
import kz.bitlab.G115security.dtos.UserView;
import kz.bitlab.G115security.entity.User;
import kz.bitlab.G115security.mappers.UserMapper;
import kz.bitlab.G115security.repository.RoleRepository;
import kz.bitlab.G115security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return (User) authentication.getPrincipal();
  }

  public UserView getUserById(Long id) {
    var user = userRepository.findById(id).orElseThrow();
    return UserMapper.INSTANCE.toView(user);
  }

  public UserView addUser(UserCreate userCreate) {
    var user = getUserByEmail(userCreate.getUserEmail());
    if (user != null) {
      return null;
    }
    if (!userCreate.getPassword().equals(userCreate.getRePassword())) {
      return null;
    }
    var newUser = UserMapper.INSTANCE.toEntity(userCreate);
    var roleUser = roleRepository.getRoleUser();
    newUser.setPassword(passwordEncoder.encode(userCreate.getPassword()));
    newUser.setRoles(List.of(roleUser));
    return UserMapper.INSTANCE.toView(userRepository.save(newUser));
  }


  public UserView updateUser(UserUpdate userUpdate) {
    var user = getUserByEmail("beka@gmail.com");
    if (!passwordEncoder.matches(userUpdate.getCurrentPassword(), user.getPassword())) {
      return null;
    }
    if (!userUpdate.getNewPassword().equals(userUpdate.getReNewPassword())) {
      return null;
    }
    user.setPassword(passwordEncoder.encode(userUpdate.getNewPassword()));
    return UserMapper.INSTANCE.toView(userRepository.save(user));
  }

  public List<UserView> getUsers() {
    var users = userRepository.findAll();
    return UserMapper.INSTANCE.toViewList(users);
  }
}
