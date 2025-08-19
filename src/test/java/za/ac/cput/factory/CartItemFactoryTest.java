package za.ac.cput.factory;
/*
CartItemFactoryTest.java
CartItemFactoryTest POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.User;
import za.ac.cput.factory.CartItemFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CartItemFactoryTest {


    private static final User user = new User.Builder()
            .setFirstName("Thando")
            .setLastName("Mseleku")
            //.setEmail("123@gmail.com")
            .setPassword("password123")
            .build();

    private static final Cart cart = new Cart.Builder()
            .setUserID(user)
            .build();
    private static final Product product = new Product.Builder()
            .setProductID(101L)
            .setTitle("Digital Art")
            .setDescription("A beautiful digital painting")
            .setPrice(49.99)
            .setCategoryID("C001")
            .build();

    private static final CartItem cartItem1 = CartItemFactory.createCartItem(cart,product,user,10,10.000);
    private static final CartItem cartItem2 = CartItemFactory.createCartItem(cart,product,user,-5,20.000);


    @Test
    @Order(1)
    void testCreateCartItem() {
        assertNotNull(cartItem1, "CartItem1 should not be null");
        System.out.println("CartItem1: " + cartItem1);
    }

    @Test
    @Order(2)
    void testCreateCartWithInvalidQuantity() {
        assertNull(cartItem2, "CartItem2 should be null due to invalid quantity");
        System.out.println("CartItem2 creation failed due to invalid quantity");
    }

    @Test
    @Order(3)
    @Disabled("Not yet implemented")
    void testCreateCartItemThatNotYetImplemented() {

    }}