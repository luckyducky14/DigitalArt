package service;
/*
PaymentService.java
Payment service
Author: Bekithemba Mrwetyana (222706066)
Date: 7 May 2025
*/
import domain.Cart;
import domain.Payment;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    public static IPaymentService service;
    public PaymentRepository repository;

    public Payment create(Payment payment) {
        return repository.save(payment);
    }
    public Payment read(String paymentID) {
        return repository.findById(paymentID).orElse(null);
    }
    public Payment update(Payment payment) {
        return repository.save(payment);
    }
    public boolean delete(String paymentID) {
        repository.deleteById(paymentID);
        return true;
    }
    public List<Payment> getAll() {
        return repository.findAll();
    }

}
