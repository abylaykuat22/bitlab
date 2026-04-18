package g145.g145market.service;

import g145.g145market.dto.CategoryCreateDto;
import g145.g145market.dto.CategoryResponse;
import g145.g145market.entity.Category;
import g145.g145market.mapper.CategoryMapper;
import g145.g145market.repository.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponse addCategory(@Valid CategoryCreateDto categoryCreateDto){
        Category category = CategoryMapper.INSTANCE.toEntity(categoryCreateDto);
        Category savedCategory = categoryRepository.save(category);
        CategoryResponse categoryResponse = CategoryMapper.INSTANCE.toResponse(savedCategory);
        return categoryResponse;
    }
    public void delete(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new NullPointerException("Don't data"));
        categoryRepository.delete(category);
    }
    public List<CategoryResponse> getCategory() {
        return  categoryRepository.findAll().stream().map(category -> CategoryResponse.builder()
                .id(category.getId())
                .nameKz(category.getNameKz())
                .nameRu(category.getNameRu())
                .nameEn(category.getNameEn())
                .code(category.getCode())
                .createdAt(category.getCreatedAt().toString())
                .build()).toList();
    }

}
