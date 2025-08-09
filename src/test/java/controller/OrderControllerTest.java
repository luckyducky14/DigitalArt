package controller;
/*
OrderControllerTest.java
Order controller test class
Author: Mpilonhle Zimela Mzimela 230197833
Date: 15 July 2025
*/


import za.ac.cput.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "/order";

    @Test
    void testCreateOrder() {
        Order order = new Order.Builder()
                .setOrderID(101)
                .setUserID(1)
                .setOrderItems(Collections.emptyList())
                .setTotalAmount(150.0)
                .setOrderDate(LocalDateTime.now())
                .setPaymentID(1)
                .setPaymentStatus("Pending")
                .build();

        ResponseEntity<Order> response = restTemplate.postForEntity(
                BASE_URL + "/create", order, Order.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetAllOrders() {
        ResponseEntity<Order[]> response = restTemplate.getForEntity(
                BASE_URL + "/getAll", Order[].class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}


