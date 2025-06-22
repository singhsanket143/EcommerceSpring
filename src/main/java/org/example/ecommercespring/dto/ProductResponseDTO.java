package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String imageUrl;
    private Long price;
    private String description;
    private String category;
    private String brand;
    private String model;
    private String color;
    private Integer discount;
    private Boolean onSale;


    public static ProductResponseDTO toProductDTO(ProductRequestDTO product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getTitle())
                .brand(product.getBrand())
                .imageUrl(product.getImage())
                .model(product.getModel())
                .price(product.getPrice())
                .color(product.getColor())
                .onSale(product.getOnSale())
                .category(product.getCategory())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .build();
    }
}
