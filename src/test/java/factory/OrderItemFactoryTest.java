package factory;
/*
OrderItemFactoryTest.java
OrderItem Factory Test class
Author: Thimma Gogwana 222213973
Date: 18 May 2025
*/

import domain.OrderItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemFactoryTest {
    private final OrderItemFactory factory = new OrderItemFactory();

    // Test data
    private final int validItemID = 1;
    private final int validOrderID = 100;
    private final int validProductID = 500;
    private final int validQuantity = 2;
    private final double validUnitPrice = 10.99;

    @Test
    void testCreateValidOrderItem() {
        OrderItem item = factory.create(validOrderID, validProductID, validQuantity, validUnitPrice);

        assertNotNull(item);
        assertEquals(validOrderID, item.getOrderID());
        assertEquals(validProductID, item.getProductID());
        assertEquals(validQuantity, item.getQuantity());
        assertEquals(validUnitPrice, item.getUnitPrice(), 0.001);
        assertEquals(21.98, item.getSubTotal(), 0.001);
    }

    @Test
    void testCreateWithIdValidOrderItem() {
        OrderItem item = factory.createWithId(validItemID, validOrderID, validProductID, validQuantity, validUnitPrice);

        assertNotNull(item);
        assertEquals(validItemID, item.getItemID());
        assertEquals(validOrderID, item.getOrderID());
        assertEquals(validProductID, item.getProductID());
        assertEquals(validQuantity, item.getQuantity());
        assertEquals(validUnitPrice, item.getUnitPrice(), 0.001);
    }

    @Test
    void testCreateWithInvalidOrderID() {
        Executable action = () -> factory.create(0, validProductID, validQuantity, validUnitPrice);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid Order ID: 0", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidProductID() {
        Executable action = () -> factory.create(validOrderID, 0, validQuantity, validUnitPrice);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid Product ID: 0", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidQuantity() {
        Executable action = () -> factory.create(validOrderID, validProductID, 0, validUnitPrice);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid quantity: 0", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidUnitPrice() {
        Executable action = () -> factory.create(validOrderID, validProductID, validQuantity, -1.0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid unit price: -1.0", exception.getMessage());
    }

    @Test
    void testCopyValidOrderItem() {
        OrderItem original = factory.create(validOrderID, validProductID, validQuantity, validUnitPrice);
        OrderItem copy = factory.copy(original);

        assertNotNull(copy);
        assertEquals(original.getOrderID(), copy.getOrderID());
        assertEquals(original.getProductID(), copy.getProductID());
        assertEquals(original.getQuantity(), copy.getQuantity());
        assertEquals(original.getUnitPrice(), copy.getUnitPrice(), 0.001);
        assertNotSame(original, copy);
    }

    @Test
    void testCopyNullOrderItem() {
        Executable action = () -> factory.copy(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Original OrderItem cannot be null", exception.getMessage());
    }

    @Test
    void testUpdateQuantityValid() {
        OrderItem original = factory.create(validOrderID, validProductID, validQuantity, validUnitPrice);
        int newQuantity = 5;
        OrderItem updated = factory.updateQuantity(original, newQuantity);

        assertNotNull(updated);
        assertEquals(newQuantity, updated.getQuantity());
        assertEquals(54.95, updated.getSubTotal(), 0.001);
        assertEquals(original.getOrderID(), updated.getOrderID());
        assertEquals(original.getProductID(), updated.getProductID());
    }

    @Test
    void testUpdateQuantityInvalid() {
        OrderItem original = factory.create(validOrderID, validProductID, validQuantity, validUnitPrice);
        Executable action = () -> factory.updateQuantity(original, 0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid quantity: 0", exception.getMessage());
    }

    @Test
    void testUpdateUnitPriceValid() {
        OrderItem original = factory.create(validOrderID, validProductID, validQuantity, validUnitPrice);
        double newUnitPrice = 15.99;
        OrderItem updated = factory.updateUnitPrice(original, newUnitPrice);

        assertNotNull(updated);
        assertEquals(newUnitPrice, updated.getUnitPrice(), 0.001);
        assertEquals(31.98, updated.getSubTotal(), 0.001);
        assertEquals(original.getOrderID(), updated.getOrderID());
        assertEquals(original.getProductID(), updated.getProductID());
    }

    @Test
    void testUpdateUnitPriceInvalid() {
        OrderItem original = factory.create(validOrderID, validProductID, validQuantity, validUnitPrice);
        Executable action = () -> factory.updateUnitPrice(original, -1.0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid unit price: -1.0", exception.getMessage());
    }

    @Test
    void testUpdateOnNullOriginal() {
        Executable action = () -> factory.updateQuantity(null, validQuantity);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Original OrderItem cannot be null", exception.getMessage());
    }
}



