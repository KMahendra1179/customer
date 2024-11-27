package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId; // Auto-generated Cart ID

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    private List<LineItem> lineItems; // List of Line Items in the Cart

    // Getter for cartId
    public Long getCartId() {
        return cartId;
    }

    // Setter for cartId
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    // Getter for lineItems
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    // Setter for lineItems
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}

