package com.example.furniverse.mapper;

import com.example.furniverse.dto.CategoryDTO;
import com.example.furniverse.entity.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    private final CategoryMapper categoryMapper=new CategoryMapperImpl();

    @Test
    void toCategoryDTO() {
        //given
        //neden constuctor calismiyoo
       Category category=new Category(1,"office furniture","for your computer");
        CategoryDTO expected=new CategoryDTO("office furniture","for your office");
        //when
        CategoryDTO actual=categoryMapper.toCategoryDTO(category);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("CategoryDTO to Category")

    void toCategoryEntity() {
        //given
        CategoryDTO categoryDTO=new CategoryDTO("office furniture","for your office");
        Category expected=new Category();
        //when
        Category actual=categoryMapper.toCategoryEntity(categoryDTO);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);


    }
}