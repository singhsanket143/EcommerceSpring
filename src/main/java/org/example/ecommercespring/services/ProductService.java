package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductDTO getProductById(Long id) throws Exception {
    //        return repo.findById(id)
    //                .map(ProductMapper::toDto)
    //                .orElseThrow(() -> new Exception("Product not found"));`

        Product product = repo.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));

         return ProductMapper.toDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product saved = repo.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(saved);
    }

}
