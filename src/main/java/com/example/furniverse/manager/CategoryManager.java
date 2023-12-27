package com.example.furniverse.manager;

import com.example.furniverse.dto.CategoryDTO;
import com.example.furniverse.dto.CategoryDTOManager;
import com.example.furniverse.dto.CategoryPageResponse;
import com.example.furniverse.entity.Category;
import com.example.furniverse.exception.CategoryNotFoundException;
import com.example.furniverse.mapper.CategoryMapper;
import com.example.furniverse.repository.CategoryRepository;
import com.example.furniverse.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDTOManager categoryDTOManager;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryPageResponse getAll(int page, int count) {

        Page<Category> categoryPage = categoryRepository.findAll(PageRequest.of(page, count));


        return new CategoryPageResponse(
                categoryPage.getContent(),
                categoryPage.getTotalElements(),
                categoryPage.getTotalPages(),
                categoryPage.hasNext()
        );
    }

    @Override
    public CategoryDTO getById(int id) {
        return categoryRepository.findById(id).stream().map(categoryMapper::toCategoryDTO).findFirst()
                .orElseThrow(()->new CategoryNotFoundException("Category is not found"));
    }

    //CategoryDto isletmeliyik ama hele isletmemisem
    @Override
    public void saveCategory(CategoryDTO categoryDTO) {
        categoryRepository.save(categoryMapper.toCategoryEntity(categoryDTO));
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
