package org.example.ecommercespring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;


    @Entity
    @Table(name = "category")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Category extends BaseEntity {


        @Column(nullable = false, name = "category_name", unique = true)
        private String name;

        //this is for showing purpose no store happens. Relationship with Porducts and the category it belongs to Many to one.
        @OneToMany(mappedBy="category")
        private List<Product> products;
    }

