package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {

    private final InventoryRepository repository;

    @Autowired
    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inventory create(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public Inventory read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id)) repository.deleteById(id);
    }

    @Override
    public List<Inventory> getAll() {
        return repository.findAll();
    }
}
