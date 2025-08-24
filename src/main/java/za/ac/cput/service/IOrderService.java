package za.ac.cput.service;

/*
IOrderService.java
Order service interface
Author: Mpilonhle Zimela Mzimela 230197833
Date: 25 May 2025
*/

import za.ac.cput.domain.Order;
import za.ac.cput.service.IService;

import java.util.List;

public interface IOrderService extends IService<Order, Long> {

    Order create(Order order);
    Order read(Long id);
    Order update(Order order);
    void delete(Long id);
    List<Order> getAllOrders();
}

