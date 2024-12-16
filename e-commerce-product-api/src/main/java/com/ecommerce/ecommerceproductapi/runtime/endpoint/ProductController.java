package com.ecommerce.ecommerceproductapi.runtime.endpoint;

import com.ecommerce.ecommerceproductapi.domain.dto.Category;
import com.ecommerce.ecommerceproductapi.domain.dto.Product;
import com.ecommerce.ecommerceproductapi.domain.dto.ProductRequestDTO;
import com.ecommerce.ecommerceproductapi.domain.service.ProductService;
import com.ecommerce.ecommerceproductapi.runtime.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(ProductRequestDTO product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public Product getProductByName (String name){
        return productService.getProductByName(name);
    }

    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategory(@PathVariable String categoryName) {
        Category category = new Category();
        category.setName(categoryName);

        return productService.getProductsByCategory(categoryName);
    }
}
