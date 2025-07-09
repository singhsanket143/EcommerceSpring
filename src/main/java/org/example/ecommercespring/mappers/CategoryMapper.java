package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;

public class CategoryMapper {


    public static Category DtoToEntity(CategoryDTO categoryDTO){

        return   Category.builder().name(categoryDTO.getName()).build();
    }

    public static CategoryDTO toDTO(Category response) {
        return CategoryDTO.builder().name(response.getName()).build();
    }
}
