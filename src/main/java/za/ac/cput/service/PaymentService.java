package za.ac.cput.service;
/*
PaymentService.java
Payment service
Author: Bekithemba Mrwetyana (222706066)
Date: 7 May 2025
*/
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Payment;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    public static IPaymentService service;

    public PaymentRepository repository;

    public Payment create(Payment payment) {
        return repository.save(payment);
    }
    public Payment read(Long paymentID) {
        return repository.findById(paymentID).orElse(null);
    }
    public Payment update(Payment payment) {
        return repository.save(payment);
    }
    public void delete(Long paymentID) {
        repository.deleteById(paymentID);
    }
    public List<Payment> getAll() {
        return repository.findAll();
    }

}
