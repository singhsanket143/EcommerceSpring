package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.*;
import org.example.ecommercespring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> result = this.categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO created = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);

    }

    @GetMapping(params = "name")
    public ResponseEntity<CategoryDTO> getCategoryByName(@RequestParam String name) {
        System.out.println("Searching category with name: " + name);
        CategoryDTO result = categoryService.getCategoryByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDTO>> getProductsOfCategory(@PathVariable Long categoryId) {
        List<ProductDTO> products = categoryService.getProductsOfCategory(categoryId);
        return ResponseEntity.ok(products);
    }

}
