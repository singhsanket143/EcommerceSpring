package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.repository.CategoryRepository;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
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
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
        Optional<Category> category  = categoryRepository.findById(productDTO.getCategory());

        Category category1 = category.orElseThrow(()->new IOException("Not found"));

        Product response = repo.save(ProductMapper.toEntity(productDTO, category1));
        return ProductMapper.toDto(response);
    }
    @Override
    public List<ProductDTO> getAllProductsOfCategory(Long id) throws Exception {
        List<Product> products = repo.findAllProductsByCategoryId(id);
        return  ProductMapper.List2ListOfDto(products);

    }

}
