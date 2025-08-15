package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void testCreateOrder() {

        Long orderID = 1L;
        Long userID = 100L;

        OrderItem item1 = new OrderItem.Builder()
                .setItemID(1L)
                .setOrderID(orderID)
                .setQuantity(2)
                .setUnitPrice(10.99)
                .calculateSubTotal()
                .build();

        OrderItem item2 = new OrderItem.Builder()
                .setItemID(2L)
                .setOrderID(orderID)
                .setQuantity(1)
                .setUnitPrice(5.99)
                .calculateSubTotal()
                .build();

        List<OrderItem> orderItems = List.of(item1, item2);
        double totalAmount = item1.getSubTotal() + item2.getSubTotal();
        LocalDateTime orderDate = LocalDateTime.now();
        Long paymentID = 500L;
        OrderStatus paymentStatus = OrderStatus.COMPLETED;

        Order order = OrderFactory.createOrder(
                orderID,
                userID,
                orderItems,
                totalAmount,
                orderDate,
                paymentID,
                paymentStatus
        );

        assertNotNull(order);
        assertEquals(orderID, order.getOrderID());
        assertEquals(userID, order.getUserID());
        assertEquals(2, order.getOrderItems().size());
        assertEquals(totalAmount, order.getTotalAmount(), 0.001);
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(paymentID, order.getPaymentID());
        assertEquals(paymentStatus, order.getPaymentStatus());

        OrderItem firstItem = order.getOrderItems().get(0);
        assertEquals(1, firstItem.getItemID());
        assertEquals(orderID, firstItem.getOrderID());
        assertEquals(2, firstItem.getQuantity());
        assertEquals(10.99, firstItem.getUnitPrice(), 0.001);
        assertEquals(21.98, firstItem.getSubTotal(), 0.001);
    }

    @Test
    void testCreateOrderWithSingleItem() {
        Long orderID = 2L;
        Long userID = 101L;

        OrderItem item = new OrderItem.Builder()
                .setItemID(3L)
                .setOrderID(orderID)
                .setQuantity(1)
                .setUnitPrice(15.50)
                .calculateSubTotal()
                .build();

        List<OrderItem> orderItems = List.of(item);
        double totalAmount = item.getSubTotal();
        LocalDateTime orderDate = LocalDateTime.of(2025, 5, 15, 10, 30);
        Long paymentID = 501L;
        OrderStatus paymentStatus = OrderStatus.PENDING;

        Order order = OrderFactory.createOrder(
                orderID,
                userID,
                orderItems,
                totalAmount,
                orderDate,
                paymentID,
                paymentStatus
        );

        assertNotNull(order);
        assertEquals(orderID, order.getOrderID());
        assertEquals(userID, order.getUserID());
        assertEquals(1, order.getOrderItems().size());
        assertEquals(totalAmount, order.getTotalAmount(), 0.001);
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(paymentID, order.getPaymentID());
        assertEquals(paymentStatus, order.getPaymentStatus());

        OrderItem orderItem = order.getOrderItems().get(0);
        assertEquals(3, orderItem.getItemID());
        assertEquals(orderID, orderItem.getOrderID());
        assertEquals(1, orderItem.getQuantity());
        assertEquals(15.50, orderItem.getUnitPrice(), 0.001);
        assertEquals(15.50, orderItem.getSubTotal(), 0.001);
    }

    @Test
    void testCreateOrderWithEmptyItems() {
        Long orderID = 3L;
        Long userID = 102L;

        List<OrderItem> orderItems = List.of();
        double totalAmount = 0.0;
        LocalDateTime orderDate = LocalDateTime.now();
        Long paymentID = 502L;
        OrderStatus paymentStatus = OrderStatus.CANCELLED;

        Order order = OrderFactory.createOrder(
                orderID,
                userID,
                orderItems,
                totalAmount,
                orderDate,
                paymentID,
                paymentStatus
        );

        assertNotNull(order);
        assertEquals(orderID, order.getOrderID());
        assertEquals(userID, order.getUserID());
        assertTrue(order.getOrderItems().isEmpty());
        assertEquals(totalAmount, order.getTotalAmount(), 0.001);
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(paymentID, order.getPaymentID());
        assertEquals(paymentStatus, order.getPaymentStatus());
    }
}
