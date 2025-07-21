package org.example.ecommercespring.Mapper;

import org.example.ecommercespring.Entity.Category;
import org.example.ecommercespring.Entity.Product;
import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        return ProductDTO.builder()
                .image(product.getImage())
                .color(product.getColor())
                .model(product.getModel())
                .price(product.getPrice())
                .title(product.getTitle())
                .description(product.getDescription())
                .CategoryId (product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO, Category category){
        return Product.builder()
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .model(productDTO.getModel())
                .price(productDTO.getPrice())
                .title(productDTO.getTitle())
                .description(productDTO.getDescription())
                .category(category)
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .discount(productDTO.getDiscount())
                .build();
    }
}
