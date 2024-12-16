package com.ecommerce.ecommerceproductapi.runtime.exception;

import org.springframework.http.HttpStatus;

public class FunctionalException extends RuntimeException {

    private final String message;
    private final HttpStatus status;

    //Constructor
    public FunctionalException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
