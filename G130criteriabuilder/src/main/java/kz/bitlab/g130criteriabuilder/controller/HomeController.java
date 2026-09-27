package kz.bitlab.g130criteriabuilder.controller;

import kz.bitlab.g130criteriabuilder.entity.Brand;
import kz.bitlab.g130criteriabuilder.entity.Notebook;
import kz.bitlab.g130criteriabuilder.entity.Processor;
import kz.bitlab.g130criteriabuilder.service.BrandService;
import kz.bitlab.g130criteriabuilder.service.NotebookService;
import kz.bitlab.g130criteriabuilder.service.ProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    @Qualifier("NotebookServiceAlternativeImpl")
    private NotebookService notebookService;
    private final BrandService brandService;
    private final ProcessorService processorService;

    @GetMapping("/")
    public String home(
            Model model,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort_by", required = false, defaultValue = "id") String sortBy,
            @RequestParam(name = "sort_order", required = false, defaultValue = "ASC") String sortOrder) {
        Page<Notebook> notebookPage = notebookService.getAllNotebooks(page, size, sortBy, sortOrder);
        List<Notebook> notebooks = notebookPage.getContent();
        model.addAttribute("notebooks", notebooks);
        model.addAttribute("currentPage", notebookPage.getNumber());
        model.addAttribute("totalPages", notebookPage.getTotalPages());
        model.addAttribute("pageSize", notebookPage.getSize());
        int[] pageNumbers = IntStream.range(0, notebookPage.getTotalPages()).toArray();
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortOrder", sortOrder);

        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);

        List<Processor> processors = processorService.getAllProcessors();
        model.addAttribute("processors", processors);
        return "home";
    }

    @GetMapping("/dynamic-search")
    public String dynamicSearch(Notebook notebook, Model model) {
        List<Notebook> notebooks = notebookService.search(notebook);
        model.addAttribute("notebooks", notebooks);

        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);

        List<Processor> processors = processorService.getAllProcessors();
        model.addAttribute("processors", processors);
        return "home";
    }

    @PostMapping("/notebooks/add")
    public String addNotebook(Notebook notebook) {
        notebookService.addNotebook(notebook);
        return "redirect:/";
    }
}
