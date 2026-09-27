package kz.bitlab.g139rest.repository.notebook;

import kz.bitlab.g139rest.entity.Notebook;

import java.util.List;

public interface CustomNotebookRepository {

    List<Notebook> dynamicSearch(Notebook notebook);
}
