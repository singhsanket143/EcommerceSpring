package org.example.ecommercespring.dto;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreAllProductResponseDTO extends FakeStoreBaseResponseDTO {
    private List<ProductRequestDTO> products;
}