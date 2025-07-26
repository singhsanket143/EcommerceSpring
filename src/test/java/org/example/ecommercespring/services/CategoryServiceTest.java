package org.example.ecommercespring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // This annotation is used to enable Mockito for the test class with JUnit
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {
        // Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        Category category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        
        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repository to return the categories

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories(); // service is actually really called

        // Assert
        assertEquals(result.size(), 3);
        verify(categoryRepository, times(1)).findAll();
        
    }
    
}
