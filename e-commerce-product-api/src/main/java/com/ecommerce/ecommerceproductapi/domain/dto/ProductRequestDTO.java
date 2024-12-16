package com.ecommerce.ecommerceproductapi.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String image;
    private boolean available;
    private String categoryName;
}
