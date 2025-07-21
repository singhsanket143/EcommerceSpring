package org.example.ecommercespring.repository;

import org.example.ecommercespring.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    This is the Custom query method using HQL . Explicitly define the query logic
    @Query("SELECT p FROM Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    @Query("SELECT p FROM Product p WHERE p.brand=:brand and p.price>:minPrice")
    List<Product>findByPriceAndBrand(@Param("minPrice") double minPrice,@Param("brand") String brand);
}
