package kz.bitlab.g139rest.repository.notebook;

import kz.bitlab.g139rest.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Long>, CustomNotebookRepository {

}
