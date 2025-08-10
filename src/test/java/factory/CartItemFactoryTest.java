package factory;
/*
CartItemFactoryTest.java
CartItemFactoryTest POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {
    static Cart cart = new Cart.Builder()
            .setCartID("C123")
            .build();

    static Product product = new Product.Builder()
            .setProductID("P456")
            .setPrice(49.99)
            .build();

        private static CartItem cartItem1 = CartItemFactory.createCartItem(cart,product,9);
        private static CartItem cartItem2 = CartItemFactory.createCartItem(cart,product,-1);

        @Test
        @Order(1)
        public void testCreateCartItem() {
            assertNotNull(cartItem1);
            System.out.println(cartItem1.toString());


        }
        @Test
        @Order(2)
        public void testCreateCartWithInvalidQuantity() {
            assertNull(cartItem2);
            System.out.println("Failed due to invalid quantity");

        }

        @Test
        @Order(3)
        @Disabled
        public void testCreateCartItemThatNotYetImplemented() {

        }}


