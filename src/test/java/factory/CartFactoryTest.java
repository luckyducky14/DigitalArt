package factory;

/*
CartFactoryTest.java
Unit test for CartFactory
Author: Bekithemba Mrwetyana (222706066)
Date: 17 May 2025
*/

import domain.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartFactoryTest {
    @Test
    void createCart_success() {
        Cart cart = CartFactory.createCart("C001", "U001", null);
        assertNotNull(cart);
        System.out.print(cart);
    }

    @Test
    void createCart_invalidCartID() {
        Cart cart = CartFactory.createCart("", "U002", null);
        assertNull(cart);
    }

    @Test
    void createCart_invalidUserID() {
        Cart cart = CartFactory.createCart("C002", "", null);
        assertNull(cart);
    }

    @Test
    void createCart_nullValues() {
        Cart cart = CartFactory.createCart(null, null, null);
        assertNull(cart);
    }

    @Test
    void createCart_emptyValues() {
        Cart cart = CartFactory.createCart("", "", null);
        assertNull(cart);
    }
}

