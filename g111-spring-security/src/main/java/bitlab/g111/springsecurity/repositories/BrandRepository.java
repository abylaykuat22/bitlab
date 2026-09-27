package bitlab.g111.springsecurity.repositories;

import bitlab.g111.springsecurity.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
