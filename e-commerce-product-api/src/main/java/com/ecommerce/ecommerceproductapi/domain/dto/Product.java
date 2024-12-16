package com.ecommerce.ecommerceproductapi.domain.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private String image;
    private boolean available;
    @ManyToOne
    private Category category;


}
