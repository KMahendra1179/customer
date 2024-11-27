package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Cart;
import com.example.demo.entity.LineItem;
import com.example.demo.exception.CartServiceException;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.LineItemRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final LineItemRepository lineItemRepository;

    public CartService(CartRepository cartRepository, LineItemRepository lineItemRepository) {
        this.cartRepository = cartRepository;
        this.lineItemRepository = lineItemRepository;
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void emptyCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartServiceException("Cart with ID " + cartId + " not found"));
        cart.getLineItems().clear();
        cartRepository.save(cart);
    }

    public Cart updateCart(Long cartId, Cart updatedCart) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartServiceException("Cart with ID " + cartId + " not found"));
        cart.setLineItems(updatedCart.getLineItems());
        return cartRepository.save(cart);
    }

    public Cart searchCart(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new CartServiceException("Cart with ID " + cartId + " not found"));
    }

    public LineItem addLineItem(Long cartId, LineItem lineItem) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartServiceException("Cart with ID " + cartId + " not found"));
        cart.getLineItems().add(lineItem);
        cartRepository.save(cart);
        return lineItem;
    }

    public void deleteLineItem(Long lineItemId) {
        if (!lineItemRepository.existsById(lineItemId)) {
            throw new CartServiceException("Line item with ID " + lineItemId + " not found");
        }
        lineItemRepository.deleteById(lineItemId);
    }

    public LineItem updateLineItem(Long lineItemId, LineItem updatedLineItem) {
        return lineItemRepository.findById(lineItemId)
                .map(lineItem -> {
                    lineItem.setProductId(updatedLineItem.getProductId());
                    lineItem.setProductName(updatedLineItem.getProductName());
                    lineItem.setQuantity(updatedLineItem.getQuantity());
                    lineItem.setPrice(updatedLineItem.getPrice());
                    return lineItemRepository.save(lineItem);
                })
                .orElseThrow(() -> new CartServiceException("Line item with ID " + lineItemId + " not found"));
    }

    public LineItem searchLineItem(Long lineItemId) {
        return lineItemRepository.findById(lineItemId)
                .orElseThrow(() -> new CartServiceException("Line item with ID " + lineItemId + " not found"));
    }
}