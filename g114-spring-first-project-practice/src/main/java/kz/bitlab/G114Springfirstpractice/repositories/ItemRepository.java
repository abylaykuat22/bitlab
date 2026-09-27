package kz.bitlab.G114Springfirstpractice.repositories;

import java.util.List;
import kz.bitlab.G114Springfirstpractice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  @Query("select i from Item i "
      + "where i.name ilike concat('%', :search, '%') "
      + "or i.description ilike concat('%', :search, '%') "
      + "or cast(i.price as string ) = :search ")
  List<Item> search(String search);
}
