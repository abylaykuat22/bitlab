package kz.bitlab.g128springrestapi.repository;

import kz.bitlab.g128springrestapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
