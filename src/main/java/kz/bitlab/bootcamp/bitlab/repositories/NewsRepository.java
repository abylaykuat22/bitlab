package kz.bitlab.bootcamp.bitlab.repositories;

import kz.bitlab.bootcamp.bitlab.model.News;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import liquibase.pro.packaged.L;
import liquibase.pro.packaged.N;
import liquibase.pro.packaged.S;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface NewsRepository extends JpaRepository<News, Long> {
    News findByDescription(String description);
}
