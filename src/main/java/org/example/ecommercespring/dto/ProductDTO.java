package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private int id;
    private String title;
    private String image;
    private String price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private String category;
    private boolean popular;
    private String discount;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", popular=" + popular +
                ", discount='" + discount + '\'' +
                '}';
    }
}
