package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.service.CartService;
import com.soprasteria.bookstore.model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    @Operation(summary = "Get cart by ID", security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cart found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - user is not authenticated"),
        @ApiResponse(responseCode = "403", description = "Forbidden - user does not have the required role"),
        @ApiResponse(responseCode = "404", description = "Cart not found")
    })
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        Cart cart = cartService.getCart(cartId);
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }
        return ResponseEntity.ok(cart);
    }

    @PostMapping
    @Operation(summary = "Add book to cart", security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Book added to cart"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - user is not authenticated"),
        @ApiResponse(responseCode = "403", description = "Forbidden - user does not have the required role"),
        @ApiResponse(responseCode = "404", description = "Cart or book not found")
    })
    public ResponseEntity<Cart> addToCart(@RequestParam Long bookId, @RequestParam int quantity) {
        Cart cart = cartService.addToCart(bookId, quantity);
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart or book not found");
        }
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/{cartId}")
    @Operation(summary = "Update cart item", security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cart item updated"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - user is not authenticated"),
        @ApiResponse(responseCode = "403", description = "Forbidden - user does not have the required role"),
        @ApiResponse(responseCode = "404", description = "Cart or book not found")
    })
    public ResponseEntity<Cart> updateCartItem(@PathVariable Long cartId, @RequestParam Long bookId, @RequestParam int quantity) {
        Cart cart = cartService.updateCartItem(cartId, bookId, quantity);
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart or book not found");
        }
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/{cartId}")
    @Operation(summary = "Remove cart item", security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cart item removed"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - user is not authenticated"),
        @ApiResponse(responseCode = "403", description = "Forbidden - user does not have the required role"),
        @ApiResponse(responseCode = "404", description = "Cart or book not found")
    })
    public ResponseEntity<Cart> removeCartItem(@PathVariable Long cartId, @RequestParam Long bookId) {
        Cart cart = cartService.removeCartItem(cartId, bookId);
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart or book not found");
        }
        return ResponseEntity.ok(cart);
    }
}
