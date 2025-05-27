package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.service.CartService;
import com.soprasteria.bookstore.model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        Cart cart = cartService.getCart(cartId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{cartId}/add")
    public ResponseEntity<Cart> addToCart(@PathVariable Long cartId, @RequestParam Long bookId, @RequestParam int quantity) {
        Cart cart = cartService.addToCart(cartId, bookId, quantity);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{cartId}/update")
    public ResponseEntity<Cart> updateCartItem(@PathVariable Long cartId, @RequestParam Long bookId, @RequestParam int quantity) {
        Cart cart = cartService.updateCartItem(cartId, bookId, quantity);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}/remove")
    public ResponseEntity<Cart> removeCartItem(@PathVariable Long cartId, @RequestParam Long bookId) {
        Cart cart = cartService.removeCartItem(cartId, bookId);
        return ResponseEntity.ok(cart);
    }
}
