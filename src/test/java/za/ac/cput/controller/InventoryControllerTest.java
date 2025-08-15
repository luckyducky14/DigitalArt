package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.InventoryFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "/inventory";


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

        ResponseEntity<Inventory> response = restTemplate.postForEntity(
                BASE_URL + "/create", inventory, Inventory.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(50, response.getBody().getQuantity());
    }

    @Test
    void testReadInventory() {
        Inventory inventory = InventoryFactory.createInventory(dummyProduct(), 20);
        Inventory created = restTemplate.postForEntity(BASE_URL + "/create", inventory, Inventory.class).getBody();

        Inventory readInventory = restTemplate.getForObject(BASE_URL + "/read/" + created.getInventoryID(), Inventory.class);
        assertNotNull(readInventory);
        assertEquals(20, readInventory.getQuantity());
    }

    @Test
    void testUpdateInventory() {
        Inventory inventory = InventoryFactory.createInventory(dummyProduct(), 10);
        Inventory created = restTemplate.postForEntity(BASE_URL + "/create", inventory, Inventory.class).getBody();

        Inventory updated = new Inventory.Builder()
                .copy(created)
                .setQuantity(25)
                .build();

        HttpEntity<Inventory> request = new HttpEntity<>(updated);
        ResponseEntity<Inventory> response = restTemplate.exchange(
                BASE_URL + "/update",
                HttpMethod.PUT,
                request,
                Inventory.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(25, response.getBody().getQuantity());
    }

    @Test
    void testDeleteInventory() {
        Inventory inventory = InventoryFactory.createInventory(dummyProduct(), 15);
        Inventory created = restTemplate.postForEntity(BASE_URL + "/create", inventory, Inventory.class).getBody();

        restTemplate.delete(BASE_URL + "/delete/" + created.getInventoryID());

        Inventory deleted = restTemplate.getForObject(BASE_URL + "/read/" + created.getInventoryID(), Inventory.class);
        assertNull(deleted);
    }

    @Test
    void testGetAllInventory() {
        Inventory inventory1 = InventoryFactory.createInventory(dummyProduct(), 5);
        Inventory inventory2 = InventoryFactory.createInventory(dummyProduct(), 10);

        restTemplate.postForEntity(BASE_URL + "/create", inventory1, Inventory.class);
        restTemplate.postForEntity(BASE_URL + "/create", inventory2, Inventory.class);

        ResponseEntity<Inventory[]> response = restTemplate.getForEntity(BASE_URL + "/getAll", Inventory[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().length >= 2);
    }
}
