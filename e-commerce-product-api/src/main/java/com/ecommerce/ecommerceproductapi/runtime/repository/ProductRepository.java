package com.ecommerce.ecommerceproductapi.runtime.repository;

import com.ecommerce.ecommerceproductapi.domain.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {
    Optional<Product> findByName(String productName);
    List<Product> findAllByOrderByIdDesc();

    List<Product> findByCategory(String category);
}
