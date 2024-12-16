package com.ecommerce.ecommerceproductapi.domain.service;

import com.ecommerce.ecommerceproductapi.domain.dto.Category;
import com.ecommerce.ecommerceproductapi.domain.dto.Product;
import com.ecommerce.ecommerceproductapi.domain.dto.ProductRequestDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String categoryName);
    Product addProduct(ProductRequestDTO    product);
    Product updateProduct(Product product);
    Product deleteProduct(int id);
    Product getProductByName(String name);


}
