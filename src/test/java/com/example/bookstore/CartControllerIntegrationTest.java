package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CartControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;

    @Test
    void getCart_shouldReturnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cart/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void addToCart_shouldAddBookAndReturnCart() throws Exception {
        Book book = new Book("Integration Book", "Author", 20.0);
        book = bookRepository.save(book);
        Cart cart = new Cart();
        cart = cartRepository.save(cart);
        mockMvc.perform(MockMvcRequestBuilders.post("/cart/" + cart.getId() + "/add")
                .param("bookId", book.getId().toString())
                .param("quantity", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(1)))
                .andExpect(jsonPath("$.items[0].book.id", is(book.getId().intValue())))
                .andExpect(jsonPath("$.items[0].quantity", is(2)));
    }

    @Test
    void updateCartItem_shouldUpdateQuantity() throws Exception {
        Book book = new Book("Integration Book", "Author", 20.0);
        book = bookRepository.save(book);
        Cart cart = new Cart();
        CartItem item = new CartItem(book, 1);
        cart.getItems().add(item);
        cart = cartRepository.save(cart);
        mockMvc.perform(MockMvcRequestBuilders.put("/cart/" + cart.getId() + "/update")
                .param("bookId", book.getId().toString())
                .param("quantity", "5")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items[0].quantity", is(5)));
    }

    @Test
    void removeCartItem_shouldRemoveBook() throws Exception {
        Book book = new Book("Integration Book", "Author", 20.0);
        book = bookRepository.save(book);
        Cart cart = new Cart();
        CartItem item = new CartItem(book, 1);
        cart.getItems().add(item);
        cart = cartRepository.save(cart);
        mockMvc.perform(MockMvcRequestBuilders.delete("/cart/" + cart.getId() + "/remove")
                .param("bookId", book.getId().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(0)));
    }
}
