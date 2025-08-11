package za.ac.cput.service;

/*
OrderServiceTest.java
Order Service test class
Author: Mpilonhle Zimela Mzimela 230197833
Date: 20 July 2025
*/

import za.ac.cput.domain.Order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repository;

    private Order testOrder;

    @BeforeEach
    void setUp() {
        // Clean DB before each test
        repository.deleteAll();

        testOrder = new Order.Builder()
                .setOrderID(1)
                .setUserID(101)
                .setOrderItems(Collections.emptyList())
                .setTotalAmount(200.00)
                .setOrderDate(LocalDateTime.now())
                .setPaymentID(201)
                .setPaymentStatus("Pending")
                .build();

        service.create(testOrder);
    }

    @Test
    void testCreate() {
        assertNotNull(testOrder);
        assertEquals(1, testOrder.getOrderID());
    }

    @Test
    void testRead() {
        Order found = service.read(testOrder.getOrderID());
        assertNotNull(found);
        assertEquals(101, found.getUserID());
    }

    @Test
    void testUpdate() {
        Order updated = new Order.Builder()
                .copy(testOrder)
                .setPaymentStatus("Completed")
                .build();

        Order result = service.update(updated);
        assertEquals("Completed", result.getPaymentStatus());
    }

    @Test
    void testDelete() {
        boolean deleted = service.delete(testOrder.getOrderID());
        assertTrue(deleted);
        assertNull(service.read(testOrder.getOrderID()));
    }

    @Test
    void testGetAll() {
        List<Order> orders = service.getAll();
        assertFalse(orders.isEmpty());
    }
}
