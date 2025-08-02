package controller;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentControllerTest {

    private static Payment payment;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "https://localhost:8080/payment";

    public static void setup(){
        payment = PaymentFactory.createPayment(LocalDate.of(2025, 8, 2), 400, "Pending", "Credit Card");
    }

    @Test
    void create() {

    }

    @Test
    void read() {

    }

    @Test
    void update() {

    }

    @Test
    void delete() {

    }

    @Test
    void getAll() {

    }
}