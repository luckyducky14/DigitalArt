package za.ac.cput.factory;

/*
CartFactoryTest.java
Unit test for CartFactory
Author: Bekithemba Mrwetyana (222706066)
Date: 17 May 2025
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartFactoryTest {

    @BeforeEach
    void setup() {

        User user = new User.Builder()
                .setUserId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        List<CartItem> cartItems = new ArrayList<>();
    }

    @Test
    void createCart() {
//        Cart cart = CartFactory.createCart(user, cartItems);
//
//        assertNotNull(cart);
//        assertEquals(user, cart.getUserID());
//        assertEquals(cartItems, cart.getCartItems());
    }

}

