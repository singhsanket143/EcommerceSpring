package org.example.ecommercespring.services;

import org.example.ecommercespring.Entity.Category;
import org.example.ecommercespring.Entity.Product;
import org.example.ecommercespring.Exceptions.ProductNotFoundException;
import org.example.ecommercespring.Mapper.ProductMapper;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.repository.CategoryRepository;
import org.example.ecommercespring.repository.ProductRepository;

public class ProductService implements IProductService{


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
        public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;

}
    @Override
    public ProductDTO getProductById(Long id) throws Exception {
      return productRepository.findById(id)
              .map(ProductMapper::toDTO)
              .orElseThrow(() -> new ProductNotFoundException("Product not found"+id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new Exception("Category not found"));
        Product saved =  productRepository.save(ProductMapper.toEntity(dto,category));
        return ProductMapper.toDTO(saved);
    }

}
