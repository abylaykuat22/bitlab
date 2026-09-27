package kz.bitlab.g139rest.controller;

import kz.bitlab.g139rest.entity.Notebook;
import kz.bitlab.g139rest.service.NotebookService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notebooks")
@RequiredArgsConstructor
public class NotebookController {

    private final NotebookService notebookService;

    @PostMapping("/dynamic-search") // нельзя использовать @GetMapping с @RequestBody. Ограничение у мобильного разработчика
    public ResponseEntity<List<Notebook>> dynamicSearch(@RequestBody Notebook notebook) {
        try {
            List<Notebook> notebooks = notebookService.dynamicSearch(notebook);
            return new ResponseEntity<>(notebooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Notebook> getAll() {
        return notebookService.getAll();
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam(required = false, defaultValue = "1") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size,
                                  @RequestParam(required = false, defaultValue = "id") String sortBy,
                                  @RequestParam(required = false, defaultValue = "ASC") String sortOrder) {
        try {
            Page<Notebook> all = notebookService.getAll(page, size, sortBy, sortOrder);
            return new ResponseEntity<>(all, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
