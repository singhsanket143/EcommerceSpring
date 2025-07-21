package org.example.ecommercespring.Mapper;

import org.example.ecommercespring.Entity.Category;
import org.example.ecommercespring.dto.CategoryDTO;

public class CategoryMapper {
    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder().build().builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }
}
