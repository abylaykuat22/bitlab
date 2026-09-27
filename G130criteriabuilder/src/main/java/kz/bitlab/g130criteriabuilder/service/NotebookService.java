package kz.bitlab.g130criteriabuilder.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import kz.bitlab.g130criteriabuilder.entity.Notebook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface NotebookService {

    Page<Notebook> getAllNotebooks(int page, int size, String sortBy, String sortOrder);

    List<Notebook> search(Notebook notebook);

    void methodOne(Notebook notebook);

    void methodTwo(Notebook notebook);

    void methodThree(Notebook notebook);

    List<Notebook> someMethod(Notebook notebook, String text);

    void addNotebook(Notebook notebook);
}
