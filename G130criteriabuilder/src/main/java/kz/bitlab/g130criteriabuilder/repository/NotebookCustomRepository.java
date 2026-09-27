package kz.bitlab.g130criteriabuilder.repository;

import kz.bitlab.g130criteriabuilder.entity.Notebook;

import java.util.List;

public interface NotebookCustomRepository {

    List<Notebook> search(Notebook notebook);
}
