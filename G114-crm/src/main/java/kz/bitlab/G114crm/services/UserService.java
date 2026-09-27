package kz.bitlab.G114crm.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kz.bitlab.G114crm.models.Role;
import kz.bitlab.G114crm.models.User;
import kz.bitlab.G114crm.repositories.RoleRepository;
import kz.bitlab.G114crm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleService roleService;

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public void addRoleToUser(Long userId, Long roleId) {
    User user = getUserById(userId);
    Role role = roleService.getRoleById(roleId);
    if (user == null || role == null) {
      return;
    }
    Set<Role> roles = user.getRoles();
    roles.add(role);
    user.setRoles(roles);
    userRepository.save(user);
  }

  public void deleteRoleFromUser(Long userId, Long roleId) {
    User user = getUserById(userId);
    Role role = roleService.getRoleById(roleId);
    if (user == null || role == null) {
      return;
    }
    Set<Role> roles = user.getRoles();
    roles.remove(role);
    user.setRoles(roles);
    userRepository.save(user);
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public int addRolesToUser(Set<Long> roleIds, Long userId) {
    if (roleIds == null || roleIds.isEmpty()) {
      return 1;
    }
    Set<Role> roles = new HashSet<>();
    for (Long id : roleIds) {
      Role role = roleService.getRoleById(id);
      roles.add(role);
    }
    User user = getUserById(userId);
    user.setRoles(roles);
    userRepository.save(user);
    return 0;
  }
}
