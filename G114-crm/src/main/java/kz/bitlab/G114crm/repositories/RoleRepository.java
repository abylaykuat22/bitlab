package kz.bitlab.G114crm.repositories;

import java.util.List;
import kz.bitlab.G114crm.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
