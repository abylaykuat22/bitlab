package kz.bitlab.G115sprinttask61.repository;

import kz.bitlab.G115sprinttask61.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
