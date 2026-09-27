package kz.bitlab.g139rest.service;

import kz.bitlab.g139rest.entity.Notebook;
import kz.bitlab.g139rest.repository.notebook.NotebookRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotebookService {

    private final NotebookRepository notebookRepository;

    public List<Notebook> dynamicSearch(Notebook notebook) {
        return notebookRepository.dynamicSearch(notebook);
    }

    public List<Notebook> getAll() {
        return notebookRepository.findAll();
    }

    public Page<Notebook> getAll(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        PageRequest request = PageRequest.of(page, size, sort);
        return notebookRepository.findAll(request);
    }

}
