package controller;

import za.ac.cput.domain.Cart;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartControllerTest {

    private static Cart cart;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "https://localhost:8080/cart";

    @Test
    @Order(1)
    void create() {

    }

    @Test
    @Order(2)
    void read() {

    }

    @Test
    @Order(3)
    void update() {

    }

    @Test
    @Order(4)
    void delete() {

    }

    @Test
    @Order(5)
    void getAll() {

    }
}