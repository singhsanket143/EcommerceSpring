package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category entity) {
        return CategoryDTO.builder()
                .name(entity.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }
}