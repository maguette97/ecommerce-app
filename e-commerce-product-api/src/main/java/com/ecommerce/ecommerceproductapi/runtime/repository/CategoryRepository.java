package com.ecommerce.ecommerceproductapi.runtime.repository;

import com.ecommerce.ecommerceproductapi.domain.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
}
