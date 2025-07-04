package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.*;
import org.example.ecommercespring.mappers.*;
import org.example.ecommercespring.entity.*;
import org.example.ecommercespring.repository.*;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    public List<ProductDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO create(ProductDTO dto) throws Exception{
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        Product saved = repo.save(ProductMapper.toEntity(dto, category));
        return ProductMapper.toDto(saved);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
