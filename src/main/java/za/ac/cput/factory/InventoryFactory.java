package za.ac.cput.factory;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;

import java.time.LocalDateTime;

public class InventoryFactory {

    public static Inventory createInventory(Product product, int quantity) {
        return new Inventory.Builder()
                .setProduct(product)
                .setQuantity(quantity)
                .setLastUpdated(LocalDateTime.now())
                .build();
    }
}

