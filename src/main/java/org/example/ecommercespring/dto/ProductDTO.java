package org.example.ecommercespring.dto;

import lombok.*;
import org.example.ecommercespring.entity.*;

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
	private String brand;
	private boolean popular;
	private Long categoryId;


}