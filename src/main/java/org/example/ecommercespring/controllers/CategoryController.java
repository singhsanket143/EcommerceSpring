package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.CategoryDTO;
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
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws IOException {
        if(name!=null && !name.isEmpty()){
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }
        List<CategoryDTO> result = this.categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto) throws Exception {
        CategoryDTO created = categoryService.createCategory(dto);
        return ResponseEntity.ok(created);
    }
}
