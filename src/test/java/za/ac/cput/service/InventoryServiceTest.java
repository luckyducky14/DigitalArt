package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.InventoryFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.repository.InventoryRepository;

@SpringBootTest

class InventoryServiceTest {
    @Autowired
    private InventoryRepository repository;

    private InventoryService service;

    @BeforeEach
    void setUp() {
        service = new InventoryService(repository);
    }

    private Product dummyProduct() {
        return new Product.Builder()
                .setProductID("prod-101")
                .setTitle("Test Product")
                .setPrice(99.99)
                .build();
    }


    @Test
    void testCreateInventory() {
        Inventory inventory = InventoryFactory.createInventory(dummyProduct(), 50);
        Inventory created = service.create(inventory);

        assertNotNull(created);
        assertEquals(50, created.getQuantity());
        assertEquals(inventory.getProduct(), created.getProduct());
    }

    @Test
    void testReadInventory() {
        Inventory inventory = service.create(InventoryFactory.createInventory(dummyProduct(), 20));
        Inventory read = service.read(inventory.getInventoryID());

        assertNotNull(read);
        assertEquals(20, read.getQuantity());
    }

    @Test
    void testUpdateInventory() {
        Inventory inventory = service.create(InventoryFactory.createInventory(dummyProduct(), 10));
        Inventory updatedInventory = new Inventory.Builder()
                .copy(inventory)
                .setQuantity(30)
                .build();

        Inventory updated = service.update(updatedInventory);

        assertNotNull(updated);
        assertEquals(30, updated.getQuantity());
    }

    @Test
    void testDeleteInventory() {
        Inventory inventory = service.create(InventoryFactory.createInventory(dummyProduct(), 15));
        service.delete(inventory.getInventoryID());

        Inventory deleted = service.read(inventory.getInventoryID());
        assertNull(deleted);
    }

    @Test
    void testGetAllInventory() {
        service.create(InventoryFactory.createInventory(dummyProduct(), 5));
        service.create(InventoryFactory.createInventory(dummyProduct(), 10));

        List<Inventory> all = service.getAll();
        assertTrue(all.size() >= 2);
    }
}
