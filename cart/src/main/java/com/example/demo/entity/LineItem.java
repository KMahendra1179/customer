package com.example.demo.entity;


import jakarta.persistence.*;

@Entity
public class LineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId; // Auto-generated Line Item ID

    private Long productId; // Product ID associated with the Line Item
    private String productName; // Product name
    private Integer quantity; // Quantity of the product
    private Double price; // Price of the product

    // Getter for itemId
    public Long getItemId() {
        return itemId;
    }

    // Setter for itemId
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    // Getter for productId
    public Long getProductId() {
        return productId;
    }

    // Setter for productId
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // Getter for productName
    public String getProductName() {
        return productName;
    }

    // Setter for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter for quantity
    public Integer getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // Getter for price
    public Double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(Double price) {
        this.price = price;
    }
}
