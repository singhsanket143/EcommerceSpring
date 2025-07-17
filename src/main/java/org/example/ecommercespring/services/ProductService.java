package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.mapper.ProductMapper;
import org.example.ecommercespring.repository.ICategoryRepository;
import org.example.ecommercespring.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    private IProductRepository repo;
    private ICategoryRepository categoryrepo;

    public ProductService(IProductRepository repo, ICategoryRepository categoryRepository) {
        this.categoryrepo = categoryRepository;
        this.repo = repo;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(Product-> ProductMapper.toDto(Product))
                .orElseThrow(()->new Exception("Product not fount"));

    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        Category category = categoryrepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        Product saved = repo.save(ProductMapper.toEntity(productDTO, category));
        return ProductMapper.toDto(saved);
    }
}
