package org.example.ecommercespring.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreSingleProductDTO extends FakeStoreBaseResponseDTO {
    private ProductRequestDTO product;
}