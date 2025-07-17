package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.mapper.CategoryMapper;
import org.example.ecommercespring.repository.ICategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository repo;

    public CategoryService(ICategoryRepository repo) {
        this.repo = repo;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> categories = new ArrayList<>();
        for (Category category: repo.findAll()){
            categories.add(CategoryMapper.toCategoryDTO(category));
        }
        return categories;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {
        Category category = repo.findByName(name)
                .orElseThrow(() -> new Exception("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws Exception {
        Category category = repo.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toCategoryDTO(category);
    }
}
