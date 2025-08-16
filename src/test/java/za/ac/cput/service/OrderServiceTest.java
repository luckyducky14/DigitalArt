package za.ac.cput.service;

/*
OrderServiceTest.java
Order Service test class
Author: Mpilonhle Zimela Mzimela 230197833
Date: 20 July 2025
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.enums.OrderStatus;
import za.ac.cput.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderServiceTest {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepository repository;

    private Order testOrder;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        testOrder = new Order.Builder()
                .setOrderID(1L)
                .setCartItem(Collections.emptyList())
                .setTotalAmount(200.00)
                .setOrderAmount(150.00)
                .setOrderDate(LocalDateTime.now())
                .setPaymentStatus(OrderStatus.PENDING)
                .build();

        service.create(testOrder);
    }

    @Test
    void a_testCreate() {
        assertNotNull(testOrder);
        assertEquals(1L, testOrder.getOrderID());
    }

    @Test
    void b_testRead() {
        Order found = service.read(testOrder.getOrderID());
        assertNotNull(found);
        assertEquals(1L, found.getOrderID());
    }

    @Test
    void c_testUpdate() {
        Order updated = new Order.Builder()
                .copy(testOrder)
                .setPaymentStatus(OrderStatus.SHIPPED)
                .build();

        Order result = service.update(updated);
        assertEquals(OrderStatus.SHIPPED, result.getPaymentStatus());
    }

    @Test
    void d_testGetAll() {
        List<Order> orders = service.getAll();
        assertNotNull(orders);
        assertFalse(orders.isEmpty());
        System.out.println("Orders: " + orders);
    }
}
