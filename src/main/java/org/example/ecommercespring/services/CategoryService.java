package org.example.ecommercespring.services;

import org.example.ecommercespring.Entity.Category;
import org.example.ecommercespring.Mapper.CategoryMapper;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.repository.CategoryRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        // Fetch all Category entities from the repository
        List<Category> categories = categoryRepository.findAll();

        // Convert each Category to CategoryDTO using the mapper
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categories) {
            categoryDTOList.add(CategoryMapper.toDto(category));
        }

        // Return the list of DTOs
        return categoryDTOList;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO dto) throws IOException {
       Category category = CategoryMapper.toEntity(dto);
       Category saved = categoryRepository.save(category);
       return CategoryMapper.toDto(saved);
    }

    @Override
    public CategoryDTO getByName(String Name) throws IOException {
       Category category=  categoryRepository.findByName(Name)
               .orElseThrow(()->new IllegalArgumentException("Category not found"));
       return CategoryMapper.toDto(category);
    }
}
