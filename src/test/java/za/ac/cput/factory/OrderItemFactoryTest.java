package za.ac.cput.factory;
/*
OrderItemFactoryTest.java
OrderItem Factory Test class
Author: Thimma Gogwana 222213973
Date: 25 May 2025
*/

import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {

    @Test
    void createOrderItem_ValidParameters_ShouldCreateSuccessfully() {
        Product product = new Product.Builder()
                .setProductID(123L)
                .setTitle("Test Product")
                .setDescription("Sample description")
                .setPrice(50.0)
                .setCategoryID("C1")
                .build();

        OrderItem orderItem = OrderItemFactory.createOrderItem(1L, product, 2, 50.0);

        assertNotNull(orderItem, "OrderItem should not be null");
        assertEquals(2, orderItem.getQuantity(), "Quantity should match");
        assertEquals(50.0, orderItem.getUnitPrice(), "Unit price should match");
        assertEquals(100.0, orderItem.getSubTotal(), "SubTotal should be calculated correctly");
        assertEquals(product, orderItem.getProduct(), "Product should match the one provided");
    }

    @Test
    void createOrderItem_InvalidOrderID_ShouldThrowException() {
        Product product = new Product.Builder()
                .setProductID(123L)
                .setTitle("Test Product")
                .setDescription("Sample description")
                .setPrice(50.0)
                .setCategoryID("C1")
                .build();

        assertThrows(IllegalArgumentException.class, () ->
                        OrderItemFactory.createOrderItem(-1L, product, 2, 50.0),
                "Negative orderID should throw IllegalArgumentException");
    }

    @Test
    void createOrderItem_NullProduct_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
                        OrderItemFactory.createOrderItem(1L, null, 2, 50.0),
                "Null product should throw IllegalArgumentException");
    }

    @Test
    void createOrderItem_InvalidQuantity_ShouldThrowException() {
        Product product = new Product.Builder()
                .setProductID(123L)
                .setTitle("Test Product")
                .setDescription("Sample description")
                .setPrice(50.0)
                .setCategoryID("C1")
                .build();

        assertThrows(IllegalArgumentException.class, () ->
                        OrderItemFactory.createOrderItem(1L, product, -5, 50.0),
                "Negative quantity should throw IllegalArgumentException");
    }

    @Test
    void createOrderItem_InvalidUnitPrice_ShouldThrowException() {
        Product product = new Product.Builder()
                .setProductID(1L)
                .setTitle("Test Product")
                .setDescription("Sample description")
                .setPrice(50.0)
                .setCategoryID("C1")
                .build();

        assertThrows(IllegalArgumentException.class, () ->
                        OrderItemFactory.createOrderItem(1L, product, 2, -10.0),
                "Negative unit price should throw IllegalArgumentException");
    }
}


