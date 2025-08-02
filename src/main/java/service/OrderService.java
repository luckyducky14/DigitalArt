package service;

/*
OrderService.java
Order service implementation
Author: Mpilonhle Zimela Mzimela 230197833
Date: 27 May 2025
*/

import domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order read(Integer orderID) {
        return repository.findById(orderID).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }

    @Override
    public boolean delete(Integer orderID) {
        if (repository.existsById(orderID)) {
            repository.deleteById(orderID);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}
