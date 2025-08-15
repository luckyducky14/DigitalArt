package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFactoryTest {

    private Product dummyProduct() {
        return new Product.Builder()
                .setProductID("prod-101")
                .setTitle("Test Product")
                .setPrice(99.99)
                .build();
    }


    @Test
    void testCreateInventory() {
        Product product = dummyProduct();
        int quantity = 50;

        Inventory inventory = InventoryFactory.createInventory(product, quantity);

        assertNotNull(inventory);
        assertNotNull(inventory.getInventoryID());
        assertEquals(product, inventory.getProduct());
        assertEquals(quantity, inventory.getQuantity());
        assertNotNull(inventory.getLastUpdated());
    }

    @Test
    void testCreateInventoryWithInvalidProduct() {
        Product invalidProduct = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                InventoryFactory.createInventory(invalidProduct, 10));

        assertEquals("Invalid product", exception.getMessage());
    }

    @Test
    void testCreateInventoryWithInvalidQuantity() {
        Product product = dummyProduct();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                InventoryFactory.createInventory(product, -5));

        assertEquals("Invalid quantity", exception.getMessage());
    }
}
