package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.OrderItemRepository;

import java.util.List;

@Service
public class OrderItemService implements IOrderItemService {

    private final OrderItemRepository repository;

    @Autowired
    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public OrderItem read(Integer itemID) {
        return repository.findById(itemID).orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public boolean delete(Integer itemID) {
        if (repository.existsById(itemID)) {
            repository.deleteById(itemID);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderItem> getAll() {
        return repository.findAll();
    }
}
