package com.example.furniverse.service;

import com.example.furniverse.dto.CategoryDTO;
import com.example.furniverse.dto.CategoryPageResponse;
import com.example.furniverse.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryPageResponse getAll(int page, int count);
    CategoryDTO getById(int id);
    void saveCategory(CategoryDTO categoryDTO);
    void deleteCategory(int id);
    //TODO:update
}
