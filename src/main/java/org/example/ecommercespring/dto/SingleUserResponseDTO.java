package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleUserResponseDTO {
    private String status;
    private String message;
    private UserDTO user;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public UserDTO getUser() {
        return user;
    }
}
