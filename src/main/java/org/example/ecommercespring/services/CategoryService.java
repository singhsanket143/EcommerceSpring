package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.mappers.CategoryMapper;
import org.example.ecommercespring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Primary
public class CategoryService implements ICategoryService {

    public final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return List.of();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        Category category = CategoryMapper.DtoToEntity(categoryDTO);
        Category response =  categoryRepository.save(category);
        return CategoryMapper.toDTO(response);

    }
}
