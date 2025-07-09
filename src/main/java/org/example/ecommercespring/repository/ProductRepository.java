package org.example.ecommercespring.repository;

import org.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "select * from product where category_id = :id", nativeQuery = true)
    List<Product> findAllProductsByCategoryId(Long id);
}


//productRepository.save()
