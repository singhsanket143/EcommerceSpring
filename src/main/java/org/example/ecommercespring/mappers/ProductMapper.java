package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static  ProductDTO toDto(Product product){
        return ProductDTO.builder().id(product.getId()).brand(product.getBrand())
                .category(product.getCategory().getId()).color(product.getColor()).description(product.getDescription())
                .discount(product.getDiscount())
                .image(product.getImage()).price(product.getPrice()).model(product.getModel()).build();
    }

    public static Product toEntity(ProductDTO productDTO,Category category){
        return Product.builder().brand(productDTO.getBrand()).image(productDTO.getImage()).model(productDTO.getModel())
                .color(productDTO.getColor()).price(productDTO.getPrice()).category(category).description(productDTO.getDescription()).build();
    }
    public static List<ProductDTO> List2ListOfDto(List<Product> products) {
        return products.stream()
                .map(product -> ProductDTO.builder()
                        .image(product.getImage())
                        .color(product.getColor())
                        .price(product.getPrice())
                        .brand(product.getBrand())
                        .discount(product.getDiscount())
                        .model(product.getModel())
                        .description(product.getDescription())
                        .category(product.getCategory().getId())
                        .build())
                .collect(Collectors.toList());
    }
}
