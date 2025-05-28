package com.soprasteria.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    private int quantity;

    public CartItem() {}
    public CartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }
}
