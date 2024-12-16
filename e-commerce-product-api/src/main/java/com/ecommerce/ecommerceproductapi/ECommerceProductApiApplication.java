package com.ecommerce.ecommerceproductapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class ECommerceProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceProductApiApplication.class, args);
    }

}
