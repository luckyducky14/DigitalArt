package za.ac.cput.controller;

import za.ac.cput.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.PaymentService;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService service;

    @Autowired
    public PaymentController(PaymentService service){
        this.service = service;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment){
        return service.create(payment);
    }
    @GetMapping("/read/{paymentID}")
    public Payment read(@PathVariable Long paymentID){
        return service.read(paymentID);
    }
    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment){
        return service.update(payment);
    }
    @DeleteMapping("/delete/{paymentID}")
    public boolean delete(@PathVariable Long paymentID){
        return service.delete(paymentID);
    }
    @GetMapping("/getAll")
    public List<Payment> getAll(){
        return service.getAll();
    }

}
