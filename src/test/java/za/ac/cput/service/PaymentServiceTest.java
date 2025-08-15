package za.ac.cput.service;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceTest {

    @Autowired
    private static IPaymentService service;

    private Payment payment = PaymentFactory.createPayment(LocalDate.of(2025, 8, 2), 400);

    @Test
    @Order(1)
    void create() {
        Payment newPayment = service.create(payment);
        assertNotNull(newPayment);
        System.out.println(newPayment);
    }

    @Test
    void read() {
        Payment read = service.read(payment.getPaymentID());
        assertNotNull(read);
        System.out.print(read);
    }

    @Test
    void update() {
        Payment newPayment = new Payment.Builder().copy(payment).setAmount(99).build();
        Payment updated = service.update(newPayment);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
        System.out.print(service.getAll());
    }
}