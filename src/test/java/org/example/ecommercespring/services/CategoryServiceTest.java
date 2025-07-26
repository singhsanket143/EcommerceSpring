package org.example.ecommercespring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
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



    private CategoryDTO categoryDTO;
    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp() {
        categoryDTO = CategoryDTO.builder().name("Electronics").build();
        category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);

    }

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {
        // Arrange
        List<Category> categories = new ArrayList<>();
        
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

    @Test
    @DisplayName("Should return empty list when no categories exist")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoriesExist() {
        // Arrange
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories();

        // Assert
        assertEquals(result.size(), 0);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should create a new category successfully")
    void createCategory_shouldCreateCategorySuccessfully() {
        // Arrange
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);

        // Act
        CategoryDTO result = categoryService.createCategory(categoryDTO);

        // Assert
        assertEquals(result.getName(), "Electronics");
        verify(categoryRepository, times(1)).save(any(Category.class));


    }

    @Test
    @DisplayName("Should return category by name")
    void getByName_shouldReturnCategoryByName() throws Exception {
        // Arrange
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(category1));

        // Act
        CategoryDTO result = categoryService.getByName("Electronics");

        // Assert
        assertEquals(result.getName(), "Electronics");
        verify(categoryRepository, times(1)).findByName("Electronics");

    }
    
}
