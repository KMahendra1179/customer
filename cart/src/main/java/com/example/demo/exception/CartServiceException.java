package com.example.demo.exception;

public class CartServiceException extends RuntimeException {
    public CartServiceException(String message) {
        super(message);
    }
}