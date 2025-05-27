package com.soprasteria.bookstore.service;

import com.soprasteria.bookstore.model.Book;
import com.soprasteria.bookstore.model.Cart;
import com.soprasteria.bookstore.model.CartItem;
import com.soprasteria.bookstore.repository.BookRepository;
import com.soprasteria.bookstore.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceTest {
    @Mock
    private CartRepository cartRepository;
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private CartService cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addToCart_shouldAddNewItem() {
        Long cartId = 1L;
        Long bookId = 2L;
        Book book = new Book("Test Book", "Author", 10.0);
        book.setId(bookId);
        Cart cart = new Cart();
        cart.setId(cartId);
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(cartRepository.save(any(Cart.class))).thenAnswer(i -> i.getArgument(0));
        Cart result = cartService.addToCart(cartId, bookId, 1);
        assertEquals(1, result.getItems().size());
        assertEquals(bookId, result.getItems().get(0).getBook().getId());
        assertEquals(1, result.getItems().get(0).getQuantity());
    }

    @Test
    void updateCartItem_shouldUpdateQuantity() {
        Long cartId = 1L;
        Long bookId = 2L;
        Book book = new Book("Test Book", "Author", 10.0);
        book.setId(bookId);
        CartItem item = new CartItem(book, 1);
        Cart cart = new Cart();
        cart.setId(cartId);
        cart.setItems(Collections.singletonList(item));
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenAnswer(i -> i.getArgument(0));
        Cart result = cartService.updateCartItem(cartId, bookId, 5);
        assertEquals(5, result.getItems().get(0).getQuantity());
    }

    @Test
    void removeCartItem_shouldRemoveItem() {
        Long cartId = 1L;
        Long bookId = 2L;
        Book book = new Book("Test Book", "Author", 10.0);
        book.setId(bookId);
        CartItem item = new CartItem(book, 1);
        Cart cart = new Cart();
        cart.setId(cartId);
        cart.setItems(new java.util.ArrayList<>(java.util.Collections.singletonList(item)));
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenAnswer(i -> i.getArgument(0));
        Cart result = cartService.removeCartItem(cartId, bookId);
        assertTrue(result.getItems().isEmpty());
    }
}
