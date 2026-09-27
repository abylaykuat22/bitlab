package kz.bitlab.g139rest.repository.notebook;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import kz.bitlab.g139rest.entity.Brand;
import kz.bitlab.g139rest.entity.Notebook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// CustomNotebookRepositoryImpl не работает, обязательно должен называться NotebookRepositoryImpl
@Repository
public class NotebookRepositoryImpl implements CustomNotebookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notebook> dynamicSearch(Notebook notebook) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);
        Root<Notebook> root = query.from(Notebook.class);

        List<Predicate> predicates = new ArrayList<>();

        String name = notebook.getName();
        if (name != null) {
            name = "%" + name.trim().toLowerCase() + "%";
            predicates.add(cb.like(cb.lower(root.get("name")), name));
        }

        String os = notebook.getOs();
        if (os != null) {
            os = os.toLowerCase().trim();
            predicates.add(cb.equal(cb.lower(root.get("os")), os));
        }

        String memory = notebook.getMemory();
        if (memory != null) {
            memory = memory.toLowerCase().trim();
            predicates.add(cb.equal(cb.lower(root.get("memory")), memory));
        }

        String ram = notebook.getRam();
        if (ram != null) {
            ram = ram.toLowerCase().trim();
            predicates.add(cb.equal(cb.lower(root.get("ram")), ram));
        }

        Double price = notebook.getPrice();
        if (price != null) {
            predicates.add(cb.le(root.get("price"), price));
        }

        Brand brand = notebook.getBrand();
        if (brand != null && brand.getId() != null) {
            predicates.add(cb.equal(root.get("brand"), brand));
        }

        Predicate[] array = predicates.toArray(new Predicate[0]);
        query.where(array);

        return entityManager.createQuery(query).getResultList();
    }
}
