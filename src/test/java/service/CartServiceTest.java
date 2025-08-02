package service;

import za.ac.cput.domain.Cart;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.service.ICartService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartServiceTest {

    private static ICartService service;

    private static Cart cart;

    @Test
    @Order(1)
    void create() {
        Cart newCart = service.create(cart);
        assertNotNull(newCart);
        System.out.println(newCart);
    }

    @Test
    @Order(2)
    void read() {
        Cart read = service.read(cart.getCartID());
        assertNotNull(read);
        System.out.print(read);
    }

    @Test
    @Order(3)
    void update() {
        Cart newCart = new Cart.Builder().copy(cart).setCartID("C01").build();
        Cart updated = service.update(newCart);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}