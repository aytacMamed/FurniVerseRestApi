package com.example.furniverse.dto;

import com.example.furniverse.entity.Category;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryDTOManager implements Function<Category,CategoryDTO> {
    @Override
    public CategoryDTO apply(Category category) {
        return new CategoryDTO
                (category.getCategoryName(), category.getDescription());
    }
}
