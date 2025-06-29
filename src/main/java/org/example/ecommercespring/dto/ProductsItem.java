package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsItem{
    private String image;
    private String color;
    private Integer price;
    private String description;
    private Integer discount;
    private String model;
    private Integer id;
    private String title;
    private String category;
    private String brand;
    private Boolean onSale;
}