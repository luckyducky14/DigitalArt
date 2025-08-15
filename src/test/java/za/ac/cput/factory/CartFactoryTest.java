package za.ac.cput.factory;

/*
CartFactoryTest.java
Unit test for CartFactory
Author: Bekithemba Mrwetyana (222706066)
Date: 17 May 2025
*/

import za.ac.cput.domain.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.factory.CartFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartFactoryTest {

    public void setup(){
        
    }

    @Test
    void createCart() {
        Cart cart = CartFactory.createCart();
        assertNotNull(cart);
        assertEquals(123, cart.getCartID());
        assertNull(cart.getUserID());
        assertNull(cart.getCartItems());
    }
}

