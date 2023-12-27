package com.example.furniverse.controller;

import com.example.furniverse.dto.CategoryDTO;
import com.example.furniverse.dto.CategoryPageResponse;
import com.example.furniverse.entity.Category;
import com.example.furniverse.manager.CategoryManager;
import com.example.furniverse.service.CategoryService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryManager;

    @GetMapping
    public ResponseEntity<CategoryPageResponse> getAll(@RequestParam(value = "page") int page , @RequestParam(value = "count") int count){
        logger.info("getAll request accepted");
        return ResponseEntity.ok(categoryManager.getAll(page,count));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById( @PathVariable int id){
        return ResponseEntity.ok(categoryManager.getById(id));
    }

    @PostMapping
   public ResponseEntity<Void> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryManager.saveCategory(categoryDTO);
        return ResponseEntity.created(null).build();

   }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        categoryManager.deleteCategory(id);
        return ResponseEntity.accepted().build();
   }
}

//getAllProduct deye bir method yaratmaliyammi?