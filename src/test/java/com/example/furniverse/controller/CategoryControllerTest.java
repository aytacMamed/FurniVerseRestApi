package com.example.furniverse.controller;

import com.example.furniverse.dto.CategoryDTO;
import com.example.furniverse.entity.Category;
import com.example.furniverse.manager.CategoryManager;
import com.example.furniverse.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    CategoryController categoryController;

    @Mock
    CategoryService categoryService;

    @BeforeEach
    void init() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
        String office = "office";
        CategoryDTO categoryDTO=new CategoryDTO(office,office);

        when(categoryService.getById(1)).thenReturn(categoryDTO);

        ResponseEntity<CategoryDTO> responseEntity = categoryController.getById(1);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());

        assertEquals(categoryDTO,responseEntity.getBody());
    }


    @Test
    void saveCategory() {


    }

    @Test
    void deleteCategory() {
    }
}