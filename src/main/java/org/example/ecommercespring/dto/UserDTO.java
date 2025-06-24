package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private int id;
    private String email;
    private String username;
    private String password;
    private NameDTO name;
    private AddressDTO address;
    private String phone;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                '}';
    }
}
