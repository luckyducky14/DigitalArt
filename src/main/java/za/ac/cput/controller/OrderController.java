package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderService service;


    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/read/{id}")
    public Order read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update/{id}")
    public Order update(@PathVariable Long id , @RequestBody Order order) {
        return service.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = service.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
