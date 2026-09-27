package kz.bitlab.g130criteriabuilder.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import kz.bitlab.g130criteriabuilder.entity.Brand;
import kz.bitlab.g130criteriabuilder.entity.Notebook;
import kz.bitlab.g130criteriabuilder.entity.Processor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NotebookRepositoryImpl implements NotebookCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Notebook> search(Notebook notebook) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);
        Root<Notebook> root = query.from(Notebook.class);

        List<Predicate> predicates = new ArrayList<>();

        String name = notebook.getName();
        if (name != null && !name.isEmpty()) {
            name = "%" + name.toLowerCase().trim() + "%";
            predicates.add(cb.like(cb.lower(root.get("name")), name));
        }

        Double price = notebook.getPrice();
        if (price != null) {
            predicates.add(cb.equal(root.get("price"), price));
        }

        String os = notebook.getOs();
        if (os != null && !os.isEmpty()) {
            os = "%" + os.toLowerCase().trim() + "%";
            predicates.add(cb.like(cb.lower(root.get("os")), os));
        }

        String memory = notebook.getMemory();
        if (memory != null && !memory.isEmpty()) {
            memory = "%" + memory.toLowerCase().trim() + "%";
            predicates.add(cb.like(cb.lower(root.get("memory")), memory));
        }

        Processor processor = notebook.getProcessor();
        if (processor != null && processor.getId() != null) {
            predicates.add(cb.equal(root.get("processor"), processor));
        }

        Brand brand = notebook.getBrand();
        if (brand != null && brand.getId() != null) {
            predicates.add(cb.equal(root.get("brand"), brand));
        }

        String ram = notebook.getRam();
        if (ram != null && !ram.isEmpty()) {
            ram = "%" + ram.toLowerCase().trim() + "%";
            predicates.add(cb.like(cb.lower(root.get("ram")), ram));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
