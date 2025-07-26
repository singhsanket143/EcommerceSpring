package org.example.ecommercespring.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.services.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private ICategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    private CategoryDTO testCategoryDTO;
    private AllProductsOfCategoryDTO testAllProductsDTO;
    private ProductDTO testProductDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new org.example.ecommercespring.exception.GlobalExceptionHandler())
                .build();
        objectMapper = new ObjectMapper();

        // Setup test data
        testCategoryDTO = CategoryDTO.builder()
                .id(1L)
                .name("Electronics")
                .build();

        testProductDTO = ProductDTO.builder()
                .id(1L)
                .title("Test Product")
                .price(99)
                .description("Test Description")
                .build();

        testAllProductsDTO = AllProductsOfCategoryDTO.builder()
                .categoryId(1L)
                .name("Electronics")
                .products(Arrays.asList(testProductDTO))
                .build();
    }

    @Test
    @DisplayName("GET /api/categories - Should return all categories when no name parameter")
    void getAllCategories_ShouldReturnAllCategories_WhenNoNameParameter() throws Exception {
        // Arrange
        List<CategoryDTO> categories = Arrays.asList(
                CategoryDTO.builder().id(1L).name("Electronics").build(),
                CategoryDTO.builder().id(2L).name("Books").build()
        );

        when(categoryService.getAllCategories()).thenReturn(categories);

        // Act & Assert
        mockMvc.perform(get("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Electronics"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Books"));

        verify(categoryService, times(1)).getAllCategories();
        verify(categoryService, never()).getByName(any());
    }

    @Test
    @DisplayName("GET /api/categories - Should return single category when name parameter provided")
    void getAllCategories_ShouldReturnSingleCategory_WhenNameParameterProvided() throws Exception {
        // Arrange
        when(categoryService.getByName("Electronics")).thenReturn(testCategoryDTO);

        // Act & Assert
        mockMvc.perform(get("/api/categories")
                        .param("name", "Electronics")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Electronics"));

        verify(categoryService, times(1)).getByName("Electronics");
        verify(categoryService, never()).getAllCategories();
    }

    @Test
    @DisplayName("GET /api/categories - Should return all categories when name parameter is blank")
    void getAllCategories_ShouldReturnAllCategories_WhenNameParameterIsBlank() throws Exception {
        // Arrange
        List<CategoryDTO> categories = Arrays.asList(testCategoryDTO);
        when(categoryService.getAllCategories()).thenReturn(categories);

        // Act & Assert
        mockMvc.perform(get("/api/categories")
                        .param("name", "   ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Electronics"));

        verify(categoryService, times(1)).getAllCategories();
        verify(categoryService, never()).getByName(any());
    }

    @Test
    @DisplayName("GET /api/categories - Should return all categories when name parameter is null")
    void getAllCategories_ShouldReturnAllCategories_WhenNameParameterIsNull() throws Exception {
        // Arrange
        List<CategoryDTO> categories = Arrays.asList(testCategoryDTO);
        when(categoryService.getAllCategories()).thenReturn(categories);

        // Act & Assert
        mockMvc.perform(get("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Electronics"));

        verify(categoryService, times(1)).getAllCategories();
        verify(categoryService, never()).getByName(any());
    }

    @Test
    @DisplayName("GET /api/categories - Should handle exception when service throws exception")
    void getAllCategories_ShouldHandleException_WhenServiceThrowsException() throws Exception {
        // Arrange
        when(categoryService.getByName("NonExistent")).thenThrow(new Exception("Category not found"));

        // Act & Assert
        mockMvc.perform(get("/api/categories")
                        .param("name", "NonExistent")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());

        verify(categoryService, times(1)).getByName("NonExistent");
    }

    @Test
    @DisplayName("POST /api/categories - Should create category successfully")
    void createCategory_ShouldCreateCategorySuccessfully() throws Exception {
        // Arrange
        CategoryDTO inputDTO = CategoryDTO.builder()
                .name("New Category")
                .build();

        CategoryDTO createdDTO = CategoryDTO.builder()
                .id(1L)
                .name("New Category")
                .build();

        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(createdDTO);

        // Act & Assert
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("New Category"));

        verify(categoryService, times(1)).createCategory(any(CategoryDTO.class));
    }

    @Test
    @DisplayName("POST /api/categories - Should create category with null id")
    void createCategory_ShouldCreateCategory_WhenInputHasNullId() throws Exception {
        // Arrange
        CategoryDTO inputDTO = CategoryDTO.builder()
                .id(null)
                .name("New Category")
                .build();

        CategoryDTO createdDTO = CategoryDTO.builder()
                .id(1L)
                .name("New Category")
                .build();

        when(categoryService.createCategory(any(CategoryDTO.class))).thenReturn(createdDTO);

        // Act & Assert
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("New Category"));

        verify(categoryService, times(1)).createCategory(any(CategoryDTO.class));
    }

    @Test
    @DisplayName("POST /api/categories - Should handle invalid JSON")
    void createCategory_ShouldHandleInvalidJson() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ invalid json }"))
                .andExpect(status().isInternalServerError());

        verify(categoryService, never()).createCategory(any());
    }

    @Test
    @DisplayName("POST /api/categories - Should handle empty body")
    void createCategory_ShouldHandleEmptyBody() throws Exception {
        // Act & Assert
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isInternalServerError());

        verify(categoryService, never()).createCategory(any());
    }

    @Test
    @DisplayName("GET /api/categories/{id}/products - Should return all products of category")
    void getAllProductsOfCategory_ShouldReturnProducts_WhenCategoryExists() throws Exception {
        // Arrange
        when(categoryService.getAllProductsOfCategory(1L)).thenReturn(testAllProductsDTO);

        // Act & Assert
        mockMvc.perform(get("/api/categories/1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.name").value("Electronics"))
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.products[0].id").value(1))
                .andExpect(jsonPath("$.products[0].title").value("Test Product"));

        verify(categoryService, times(1)).getAllProductsOfCategory(1L);
    }

    @Test
    @DisplayName("GET /api/categories/{id}/products - Should return empty products list")
    void getAllProductsOfCategory_ShouldReturnEmptyProductsList_WhenCategoryHasNoProducts() throws Exception {
        // Arrange
        AllProductsOfCategoryDTO emptyProductsDTO = AllProductsOfCategoryDTO.builder()
                .categoryId(1L)
                .name("Empty Category")
                .products(Arrays.asList())
                .build();

        when(categoryService.getAllProductsOfCategory(1L)).thenReturn(emptyProductsDTO);

        // Act & Assert
        mockMvc.perform(get("/api/categories/1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.name").value("Empty Category"))
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.products").isEmpty());

        verify(categoryService, times(1)).getAllProductsOfCategory(1L);
    }

    @Test
    @DisplayName("GET /api/categories/{id}/products - Should handle exception when category not found")
    void getAllProductsOfCategory_ShouldHandleException_WhenCategoryNotFound() throws Exception {
        // Arrange
        when(categoryService.getAllProductsOfCategory(999L)).thenThrow(new Exception("Category not found"));

        // Act & Assert
        mockMvc.perform(get("/api/categories/999/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());

        verify(categoryService, times(1)).getAllProductsOfCategory(999L);
    }

    @Test
    @DisplayName("GET /api/categories/{id}/products - Should handle invalid ID format")
    void getAllProductsOfCategory_ShouldHandleInvalidIdFormat() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/categories/invalid/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());

        verify(categoryService, never()).getAllProductsOfCategory(any());
    }

    @Test
    @DisplayName("GET /api/categories/{id}/products - Should handle multiple products")
    void getAllProductsOfCategory_ShouldHandleMultipleProducts() throws Exception {
        // Arrange
        ProductDTO product1 = ProductDTO.builder().id(1L).title("Product 1").price(99).build();
        ProductDTO product2 = ProductDTO.builder().id(2L).title("Product 2").price(149).build();

        AllProductsOfCategoryDTO multipleProductsDTO = AllProductsOfCategoryDTO.builder()
                .categoryId(1L)
                .name("Electronics")
                .products(Arrays.asList(product1, product2))
                .build();

        when(categoryService.getAllProductsOfCategory(1L)).thenReturn(multipleProductsDTO);

        // Act & Assert
        mockMvc.perform(get("/api/categories/1/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoryId").value(1))
                .andExpect(jsonPath("$.name").value("Electronics"))
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.products").isArray())
                .andExpect(jsonPath("$.products.length()").value(2))
                .andExpect(jsonPath("$.products[0].title").value("Product 1"))
                .andExpect(jsonPath("$.products[1].title").value("Product 2"));

        verify(categoryService, times(1)).getAllProductsOfCategory(1L);
    }

    @Test
    @DisplayName("POST /api/categories - Should handle service exception")
    void createCategory_ShouldHandleServiceException() throws Exception {
        // Arrange
        CategoryDTO inputDTO = CategoryDTO.builder().name("Test").build();
        when(categoryService.createCategory(any(CategoryDTO.class)))
                .thenThrow(new RuntimeException("Service error"));

        // Act & Assert
        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDTO)))
                .andExpect(status().isInternalServerError());

        verify(categoryService, times(1)).createCategory(any(CategoryDTO.class));
    }

    @Test
    @DisplayName("GET /api/categories - Should handle service exception for getAllCategories")
    void getAllCategories_ShouldHandleServiceException_ForGetAllCategories() throws Exception {
        // Arrange
        when(categoryService.getAllCategories()).thenThrow(new RuntimeException("Service error"));

        // Act & Assert
        mockMvc.perform(get("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());

        verify(categoryService, times(1)).getAllCategories();
    }
} 