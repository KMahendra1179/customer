package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Cart;
import com.example.demo.entity.LineItem;
import com.example.demo.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add a new Cart
    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.addCart(cart);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    // Empty a Cart by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> emptyCart(@PathVariable("id") Long cartId) {
        cartService.emptyCart(cartId);
        return new ResponseEntity<>("Cart emptied successfully", HttpStatus.OK);
    }

    // Update a Cart by ID
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") Long cartId, @RequestBody Cart updatedCart) {
        Cart cart = cartService.updateCart(cartId, updatedCart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // Get a Cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> searchCart(@PathVariable("id") Long cartId) {
        Cart cart = cartService.searchCart(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // Add a LineItem to a Cart
    @PostMapping("/{cartId}/lineitem")
    public ResponseEntity<LineItem> addLineItem(@PathVariable("cartId") Long cartId, @RequestBody LineItem lineItem) {
        LineItem createdLineItem = cartService.addLineItem(cartId, lineItem);
        return new ResponseEntity<>(createdLineItem, HttpStatus.CREATED);
    }

    // Delete a LineItem by ID
    @DeleteMapping("/lineitem/{lineItemId}")
    public ResponseEntity<String> deleteLineItem(@PathVariable("lineItemId") Long lineItemId) {
        cartService.deleteLineItem(lineItemId);
        return new ResponseEntity<>("Line item deleted successfully", HttpStatus.OK);
    }

    // Update a LineItem by ID
    @PutMapping("/lineitem/{lineItemId}")
    public ResponseEntity<LineItem> updateLineItem(@PathVariable("lineItemId") Long lineItemId, @RequestBody LineItem updatedLineItem) {
        LineItem lineItem = cartService.updateLineItem(lineItemId, updatedLineItem);
        return new ResponseEntity<>(lineItem, HttpStatus.OK);
    }

    // Get a LineItem by ID
    @GetMapping("/lineitem/{lineItemId}")
    public ResponseEntity<LineItem> searchLineItem(@PathVariable("lineItemId") Long lineItemId) {
        LineItem lineItem = cartService.searchLineItem(lineItemId);
        return new ResponseEntity<>(lineItem, HttpStatus.OK);
    }
}