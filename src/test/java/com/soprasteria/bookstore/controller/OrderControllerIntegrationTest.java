package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.model.Book;
import com.soprasteria.bookstore.model.Cart;
import com.soprasteria.bookstore.model.CartItem;
import com.soprasteria.bookstore.model.User;
import com.soprasteria.bookstore.repository.BookRepository;
import com.soprasteria.bookstore.repository.CartRepository;
import com.soprasteria.bookstore.repository.OrderRepository;
import com.soprasteria.bookstore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @org.junit.jupiter.api.BeforeEach
    void setupUser() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = new User("admin", passwordEncoder.encode("secret"));
            user.setRole("ROLE_USER");
            userRepository.save(user);
        }
    }

    @Test
    void checkout_shouldSucceed() throws Exception {
        Book book = new Book("Order Book", "Author", 30.0);
        book = bookRepository.save(book);
        Cart cart = new Cart();
        CartItem item = new CartItem(book, 2);
        cart.getItems().add(item);
        cart = cartRepository.save(cart);
        mockMvc.perform(post("/order/checkout")
                .param("cartId", cart.getId().toString())
                .accept(MediaType.APPLICATION_JSON)
                .with(org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic("admin", "secret")))
                .andExpect(status().isOk());
    }
}
