package g145.g145market.controller;

import g145.g145market.dto.CategoryCreateDto;
import g145.g145market.dto.CategoryResponse;
import g145.g145market.service.CategoryService;
import g145.g145market.service.Excel2Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final Excel2Service excel2Service;

    @GetMapping
    public List<CategoryResponse> getCategory(){
        List<CategoryResponse> categoryResponses = categoryService.getCategory();
        return categoryResponses;
    }

    @PostMapping
    public CategoryResponse addCategory(@Valid @RequestBody CategoryCreateDto categoryCreateDto){
        return categoryService.addCategory(categoryCreateDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
         categoryService.delete(id);
         return ResponseEntity.status(200).build();
    }
    @GetMapping("/exel")
    public ResponseEntity<?> exportCategories(){
        ByteArrayInputStream bais = excel2Service.exportCategories();
        InputStreamResource resource = new InputStreamResource(bais);
        final String filename = "Categories.xlsx";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + filename + "\"")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);

    }

    @PostMapping("/import")
    public List<CategoryResponse> importCategories(MultipartFile file){
        return excel2Service.importCategories(file);
    }

}
