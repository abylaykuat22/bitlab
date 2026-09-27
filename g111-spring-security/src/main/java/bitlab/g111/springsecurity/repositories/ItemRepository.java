package bitlab.g111.springsecurity.repositories;

import bitlab.g111.springsecurity.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
