package kz.bitlab.G114crm.services;

import java.util.List;
import kz.bitlab.G114crm.models.Role;
import kz.bitlab.G114crm.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  @Autowired
  private RoleRepository roleRepository;

  public List<Role> getRoles() {
    return roleRepository.findAll();
  }

  public Role getRoleById(Long id) {
    return roleRepository.findById(id).orElse(null);
  }
}
