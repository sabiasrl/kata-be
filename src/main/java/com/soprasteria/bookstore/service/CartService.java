package com.soprasteria.bookstore.service;

import com.soprasteria.bookstore.model.*;
import com.soprasteria.bookstore.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;

    public CartService(CartRepository cartRepository, BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
    }

    public Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElseGet(Cart::new);
    }

    @Transactional
    public Cart addToCart(Long bookId, int quantity) {
        Cart cart = new Cart();
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getBook().getId().equals(bookId))
                .findFirst();
        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            Book book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new IllegalArgumentException("Book not found"));
            cart.getItems().add(new CartItem(book, quantity));
        }
        return cartRepository.save(cart);
    }

    @Transactional
    public Cart updateCartItem(Long cartId, Long bookId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        cart.getItems().stream()
                .filter(item -> item.getBook().getId().equals(bookId))
                .findFirst()
                .ifPresentOrElse(item -> item.setQuantity(quantity),
                    () -> {
                        Book book = bookRepository.findById(bookId)
                                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
                        cart.getItems().add(new CartItem(book, quantity));
                    });
        return cartRepository.save(cart);
    }

    @Transactional
    public Cart removeCartItem(Long cartId, Long bookId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        cart.getItems().removeIf(item -> item.getBook().getId().equals(bookId));
        return cartRepository.save(cart);
    }
}
