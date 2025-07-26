package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.mappers.CategoryMapper;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category testCategory;
    private CategoryDTO testCategoryDTO;
    private Product testProduct;
    private ProductDTO testProductDTO;

    @BeforeEach
    void setUp() {
        // Setup test data
        testCategory = Category.builder()
                .name("Electronics")
                .build();
        testCategory.setId(1L);

        testCategoryDTO = CategoryDTO.builder()
                .id(1L)
                .name("Electronics")
                .build();

        testProduct = Product.builder()
                .title("Test Product")
                .price(99)
                .description("Test Description")
                .category(testCategory)
                .build();
        testProduct.setId(1L);

        testProductDTO = ProductMapper.toDto(testProduct);

        // Set up the products list in testCategory
        testCategory.setProducts(Arrays.asList(testProduct));
    }

    @Test
    @DisplayName("Should return all categories successfully")
    void getAllCategories_ShouldReturnAllCategories() {
        // Arrange
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        List<Category> categories = Arrays.asList(category1, category2);

        when(categoryRepository.findAll()).thenReturn(categories);

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Electronics");
        assertThat(result.get(1).getName()).isEqualTo("Books");
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no categories exist")
    void getAllCategories_ShouldReturnEmptyList_WhenNoCategoriesExist() {
        // Arrange
        when(categoryRepository.findAll()).thenReturn(Arrays.asList());

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should create category successfully")
    void createCategory_ShouldCreateCategorySuccessfully() {
        // Arrange
        CategoryDTO inputDTO = CategoryDTO.builder()
                .name("New Category")
                .build();

        Category savedCategory = Category.builder()
                .name("New Category")
                .build();
        savedCategory.setId(1L);

        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);

        // Act
        CategoryDTO result = categoryService.createCategory(inputDTO);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("New Category");
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    @DisplayName("Should create category with null id in input DTO")
    void createCategory_ShouldCreateCategory_WhenInputDTOHasNullId() {
        // Arrange
        CategoryDTO inputDTO = CategoryDTO.builder()
                .id(null)
                .name("New Category")
                .build();

        Category savedCategory = Category.builder()
                .name("New Category")
                .build();
        savedCategory.setId(1L);

        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);

        // Act
        CategoryDTO result = categoryService.createCategory(inputDTO);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("New Category");
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    @DisplayName("Should get category by name successfully")
    void getByName_ShouldReturnCategory_WhenCategoryExists() throws Exception {
        // Arrange
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(testCategory));

        // Act
        CategoryDTO result = categoryService.getByName("Electronics");

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Electronics");
        verify(categoryRepository, times(1)).findByName("Electronics");
    }

    @Test
    @DisplayName("Should throw exception when category not found by name")
    void getByName_ShouldThrowException_WhenCategoryNotFound() {
        // Arrange
        when(categoryRepository.findByName("NonExistent")).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> categoryService.getByName("NonExistent"))
                .isInstanceOf(Exception.class)
                .hasMessage("Category not found with name: NonExistent");

        verify(categoryRepository, times(1)).findByName("NonExistent");
    }

    @Test
    @DisplayName("Should get all products of category successfully")
    void getAllProductsOfCategory_ShouldReturnProducts_WhenCategoryExists() throws Exception {
        // Arrange
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(testCategory));

        // Act
        AllProductsOfCategoryDTO result = categoryService.getAllProductsOfCategory(1L);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getCategoryId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Electronics");
        assertThat(result.getProducts()).hasSize(1);
        assertThat(result.getProducts().get(0).getTitle()).isEqualTo("Test Product");
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should return empty products list when category has no products")
    void getAllProductsOfCategory_ShouldReturnEmptyProductsList_WhenCategoryHasNoProducts() throws Exception {
        // Arrange
        Category categoryWithoutProducts = Category.builder()
                .name("Empty Category")
                .build();
        categoryWithoutProducts.setId(1L);
        categoryWithoutProducts.setProducts(Arrays.asList());

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(categoryWithoutProducts));

        // Act
        AllProductsOfCategoryDTO result = categoryService.getAllProductsOfCategory(1L);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getCategoryId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Empty Category");
        assertThat(result.getProducts()).isEmpty();
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw exception when category not found by id")
    void getAllProductsOfCategory_ShouldThrowException_WhenCategoryNotFound() {
        // Arrange
        when(categoryRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThatThrownBy(() -> categoryService.getAllProductsOfCategory(999L))
                .isInstanceOf(Exception.class)
                .hasMessage("Category not found with id: 999");

        verify(categoryRepository, times(1)).findById(999L);
    }

    @Test
    @DisplayName("Should handle multiple products in category")
    void getAllProductsOfCategory_ShouldHandleMultipleProducts() throws Exception {
        // Arrange
        Product product1 = Product.builder()
                .title("Product 1")
                .price(99)
                .description("Description 1")
                .category(testCategory)
                .build();
        product1.setId(1L);

        Product product2 = Product.builder()
                .title("Product 2")
                .price(149)
                .description("Description 2")
                .category(testCategory)
                .build();
        product2.setId(2L);

        Category categoryWithMultipleProducts = Category.builder()
                .name("Electronics")
                .products(Arrays.asList(product1, product2))
                .build();
        categoryWithMultipleProducts.setId(1L);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(categoryWithMultipleProducts));

        // Act
        AllProductsOfCategoryDTO result = categoryService.getAllProductsOfCategory(1L);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getCategoryId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Electronics");
        assertThat(result.getProducts()).hasSize(2);
        assertThat(result.getProducts().get(0).getTitle()).isEqualTo("Product 1");
        assertThat(result.getProducts().get(1).getTitle()).isEqualTo("Product 2");
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should verify mapper is called correctly in getAllCategories")
    void getAllCategories_ShouldCallMapperCorrectly() {
        // Arrange
        Category category = Category.builder().name("Test").build();
        category.setId(1L);
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getName()).isEqualTo("Test");
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should verify mapper is called correctly in createCategory")
    void createCategory_ShouldCallMapperCorrectly() {
        // Arrange
        CategoryDTO inputDTO = CategoryDTO.builder().name("Test Category").build();
        Category savedCategory = Category.builder().name("Test Category").build();
        savedCategory.setId(1L);
        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);

        // Act
        CategoryDTO result = categoryService.createCategory(inputDTO);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Test Category");
        verify(categoryRepository, times(1)).save(any(Category.class));
    }
} 