package factory;
/*
CartItemFctory.java
CartItemFactory POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import za.ac.cput.domain.CartItem;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

        private static CartItem cartItem1 = CartItemFactory.createCartItem(10,11,50,20);
        private static CartItem cartItem2 = CartItemFactory.createCartItem(-1,30,05,80);

        @Test
        @Order(1)
        public void testCreateCartItem() {
            assertNotNull(cartItem1);
            System.out.println(cartItem1.toString());


        }
        @Test
        @Order(2)
        public void testCreateCartWithInvalidCartItemID() {
            assertNull(cartItem2);
            System.out.println("Failed due to invalid cart item ID.");

        }

        @Test
        @Order(3)
        @Disabled
        public void testCreateCartItemThatNotYetImplemented() {

        }}


