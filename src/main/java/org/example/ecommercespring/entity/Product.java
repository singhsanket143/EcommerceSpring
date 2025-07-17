package org.example.ecommercespring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private Long id;
    private String title;
    private String brand;
    private boolean popular;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}
