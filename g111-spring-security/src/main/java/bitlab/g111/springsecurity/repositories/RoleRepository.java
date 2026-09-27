package bitlab.g111.springsecurity.repositories;

import bitlab.g111.springsecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  @Query("select r from Role r where r.name='ROLE_USER'")
  Role getUserRole();
}
