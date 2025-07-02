package org.example.ecommercespring.Mapper;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;

import java.util.List;

public class FakeStoreCategrory {
    public static  FakeStoreCategoryResponseDTO toFakeStoreResponse(){
        return null;
    }
    public static List<CategoryDTO> toCategoryDTO(FakeStoreCategoryResponseDTO fakeStoreCategoryResponseDTO){
        return fakeStoreCategoryResponseDTO.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

}
