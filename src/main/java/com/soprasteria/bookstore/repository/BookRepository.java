package com.soprasteria.bookstore.repository;

import com.soprasteria.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Additional query methods if needed
}
