package org.example.ecommercespring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Category extends BaseEntity{
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
@Column(nullable=false,unique = true)
    private String name;
@OneToMany(mappedBy = "category")
private List<Product> products;
}


