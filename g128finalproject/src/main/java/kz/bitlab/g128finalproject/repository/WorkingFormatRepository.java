package kz.bitlab.g128finalproject.repository;

import kz.bitlab.g128finalproject.entity.WorkingFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingFormatRepository extends JpaRepository<WorkingFormat, Long> {
}
