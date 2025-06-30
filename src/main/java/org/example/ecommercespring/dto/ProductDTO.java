package org.example.ecommercespring.dto;

import lombok.*;
import org.example.ecommercespring.entity.Product;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO{
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private Long id;
	private String title;
	private String category;
	private String brand;
	private boolean popular;

	public static ProductDTO fromEntity(Product product) {
		return ProductDTO.builder()
				.id(product.getId())
				.image(product.getImage())
				.color(product.getColor())
				.price(product.getPrice())
				.description(product.getDescription())
				.discount(product.getDiscount())
				.model(product.getModel())
				.title(product.getTitle())
				.category(product.getCategory())
				.brand(product.getBrand())
				.popular(product.isPopular())
				.build();
	}

	public Product toEntity() {
		return Product.builder()
				.image(this.image)
				.color(this.color)
				.price(this.price)
				.description(this.description)
				.discount(this.discount)
				.model(this.model)
				.title(this.title)
				.category(this.category)
				.brand(this.brand)
				.popular(this.popular)
				.build();
	}

}