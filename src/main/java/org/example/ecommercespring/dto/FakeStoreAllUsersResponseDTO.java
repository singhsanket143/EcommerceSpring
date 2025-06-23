package org.example.ecommercespring.dto;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreAllUsersResponseDTO extends FakeStoreBaseResponseDTO {

    private List<UserDTO> users;
}
