package kz.bitlab.g130criteriabuilder.service.impl;

import kz.bitlab.g130criteriabuilder.entity.Notebook;
import kz.bitlab.g130criteriabuilder.repository.NotebookRepository;
import kz.bitlab.g130criteriabuilder.service.NotebookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NotebookServiceImpl")
@Primary
@RequiredArgsConstructor
@Slf4j
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;

    public Page<Notebook> getAllNotebooks(int page, int size, String sortBy, String sortOrder) {
        log.info("Started method getAllNotebooks. page:{}, size:{}, sortBy:{}, sortOrder:{}", page, size, sortBy, sortOrder);
        Sort.Direction direction = sortOrder.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Notebook> result = notebookRepository.findAll(pageRequest);
        log.info("Completed method getAllNotebooks. notebooks size:{}", result.getContent().size());
        return result;
    }

    public List<Notebook> search(Notebook notebook) {
        return notebookRepository.search(notebook);
    }

    public void methodOne(Notebook notebook) {

    }

    public void methodTwo(Notebook notebook) {

    }

    public void methodThree(Notebook notebook) {

    }

    @Override
    public List<Notebook> someMethod(Notebook notebook, String text) {
        return List.of();
    }

    @Override
    public void addNotebook(Notebook notebook) {
        log.info("Started method addNotebook from NotebookServiceImpl");
        notebookRepository.save(notebook);
    }
}
