package com.ecommerce.ecommerceproductapi.runtime.service;

import com.ecommerce.ecommerceproductapi.domain.dto.Category;
import com.ecommerce.ecommerceproductapi.domain.dto.Product;
import com.ecommerce.ecommerceproductapi.domain.dto.ProductRequestDTO;
import com.ecommerce.ecommerceproductapi.domain.service.ProductService;
import com.ecommerce.ecommerceproductapi.runtime.exception.FunctionalException;
import com.ecommerce.ecommerceproductapi.runtime.repository.CategoryRepository;
import com.ecommerce.ecommerceproductapi.runtime.repository.ProductRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Product addProduct(ProductRequestDTO productRequest) {

        try {
            Product product = new Product();
            product.setName(productRequest.getName());
            product.setDescription(productRequest.getDescription());
            product.setPrice(productRequest.getPrice());
            product.setQuantity(productRequest.getQuantity());
            product.setImage(productRequest.getImage());
            product.setAvailable(productRequest.isAvailable());


            Category category = categoryRepository.findByName(productRequest.getCategoryName());
            if (category != null) {
                product.setCategory(category);
            } else {
                throw new FunctionalException("Category not found ", HttpStatus.NOT_FOUND);
            }

            return productRepository.save(product);


        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                throw new FunctionalException("Product already exists", HttpStatus.CONFLICT);
            }
            throw new FunctionalException("Error saving product", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new FunctionalException("Product not found", HttpStatus.NOT_FOUND));
    }


    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepository.findByCategory(categoryName);
    }
}