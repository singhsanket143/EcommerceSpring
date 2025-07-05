package org.example.ecommercespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductCategoryDTO{
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private boolean onSale;
	private String model;
	private int id;
	private String title;
	private String category;
	private String brand;
}