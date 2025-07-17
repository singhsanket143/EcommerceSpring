package org.example.ecommercespring.mapper;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category){
        return CategoryDTO.builder().id(category.getId())
                        .name(category.getName())
                                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }
}
