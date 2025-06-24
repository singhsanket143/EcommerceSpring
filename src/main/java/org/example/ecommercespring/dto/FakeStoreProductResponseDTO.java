package org.example.ecommercespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductResponseDTO {
	private ProductDTO product;
	private String message;
	private String status;
}