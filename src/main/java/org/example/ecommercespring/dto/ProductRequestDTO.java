package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private Long id;
    private String title;
    private String image;
    private Long price;
    private String description;
    private String category;
    private String brand;
    private String model;
    private String color;
    private Integer discount;
    private Boolean onSale;
}
