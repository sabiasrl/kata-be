package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void getAllBooks_returnsListOfBooks() {
        BookRepository mockRepo = mock(BookRepository.class);
        BookService service = new BookService(mockRepo);
        List<Book> books = Arrays.asList(
            new Book("Book 1", "Author 1", 10.0),
            new Book("Book 2", "Author 2", 20.0)
        );
        when(mockRepo.findAll()).thenReturn(books);
        List<Book> result = service.getAllBooks();
        assertEquals(2, result.size());
        assertEquals("Book 1", result.get(0).getTitle());
    }
}
