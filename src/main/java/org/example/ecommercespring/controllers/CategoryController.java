package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductResponseDTO;
import org.example.ecommercespring.services.ICategoryService;
import org.example.ecommercespring.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final ICategoryService categoryService;

    private final IProductService productService;

    public CategoryController(ICategoryService categoryService, IProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryService.getAllCategories();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) throws IOException {
        return this.productService.findProductById(id);
    }

    @GetMapping("/products/category")
    public List<ProductResponseDTO> getProductsByCategory(@RequestParam String type) throws IOException {
        return this.productService.getProductsByCategory(type);
    }
}
