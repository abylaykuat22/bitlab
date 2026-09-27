package kz.bitlab.g130criteriabuilder.repository;

import kz.bitlab.g130criteriabuilder.entity.Brand;
import kz.bitlab.g130criteriabuilder.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
