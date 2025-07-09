package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO{
	private String image;
	private String color;
	private Double price;
	private String description;
	private Double discount;
	private String model;
	private Long id;
	private String title;
	private Long category;
	private String brand;
}