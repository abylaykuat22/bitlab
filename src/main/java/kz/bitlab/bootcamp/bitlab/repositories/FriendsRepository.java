package kz.bitlab.bootcamp.bitlab.repositories;

import kz.bitlab.bootcamp.bitlab.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FriendsRepository extends JpaRepository<Friends, Long> {
}
