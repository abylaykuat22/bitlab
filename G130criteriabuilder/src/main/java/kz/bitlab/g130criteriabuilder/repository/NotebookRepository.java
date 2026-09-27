package kz.bitlab.g130criteriabuilder.repository;

import jakarta.persistence.EntityManager;
import kz.bitlab.g130criteriabuilder.entity.Notebook;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long>, NotebookCustomRepository {

}
