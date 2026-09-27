package kz.bitlab.G115rest.repository;

import java.util.List;
import kz.bitlab.G115rest.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  @Query("select i from Item i where "
      + "i.name ilike concat('%', :search, '%') "
      + "or i.caption ilike concat('%', :search, '%') "
      + "or cast(i.price as string) = :search")
  List<Item> findFilteredItems(String search);
}
