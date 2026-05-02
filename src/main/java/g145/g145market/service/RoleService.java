package g145.g145market.service;

import g145.g145market.entity.Role;
import g145.g145market.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("ROLE_USER not found"));
    }
}
