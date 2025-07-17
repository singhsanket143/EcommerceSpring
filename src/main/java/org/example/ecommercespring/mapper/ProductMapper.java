package org.example.ecommercespring.mapper;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        if (product == null) {
            return null;
        }
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .image(product.getImage())
                .brand(product.getBrand())
                .color(product.getColor())
                .discount(product.getDiscount())
                .model(product.getModel())
                .popular(product.isPopular())
                .build();

    }

    public static Product toEntity(ProductDTO productDTO, Category category) {
        if (productDTO == null) {
            return null;
        }
        return Product.builder()
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .image(productDTO.getImage())
                .brand(productDTO.getBrand())
                .color(productDTO.getColor())
                .category(category)
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .popular(productDTO.isPopular())
                .build();
    }
}
