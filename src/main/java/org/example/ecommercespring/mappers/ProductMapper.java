package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.entity.Category;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .brand(product.getBrand())
                .color(product.getColor())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .image(product.getImage())
                .model(product.getModel())
                .popular(product.isPopular())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public static Product toEntity(ProductDTO dto, Category category) {
        return Product.builder()
                .title(dto.getTitle())
                .price(dto.getPrice())
                .brand(dto.getBrand())
                .color(dto.getColor())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .image(dto.getImage())
                .model(dto.getModel())
                .popular(dto.isPopular())
                .category(category)
                .build();
    }

}
