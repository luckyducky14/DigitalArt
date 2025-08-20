package za.ac.cput.factory;

/*
ProductFactoryTest.java
Product Factory Test class
Author: Thimna Gogwana 222213973
Date: 25 May 2025
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductFactoryTest {

    @Autowired
    private ProductFactory productFactory;

    private static Product product1;
    private static Product product2;

    @Test
    @Order(1)
    void a_createProducts() {
        product1 = productFactory.create(1L, 1001L, "Portrait Art", "Digital portrait of a person", 150.0);
        assertNotNull(product1);
        assertEquals("Portrait Art", product1.getTitle());
        assertEquals("Digital portrait of a person", product1.getDescription());
        assertEquals(150.0, product1.getPrice());
        assertEquals("1001", product1.getCategoryID()); // note: categoryID is stored as String in entity
        System.out.println("Product1 created: " + product1);

        product2 = productFactory.create(2L, 1002L, "Abstract Art", "Colorful abstract design", 200.0);
        assertNotNull(product2);
        assertEquals("Abstract Art", product2.getTitle());
        assertEquals("Colorful abstract design", product2.getDescription());
        assertEquals(200.0, product2.getPrice());
        assertEquals("1002", product2.getCategoryID());
        System.out.println("Product2 created: " + product2);
    }

    @Test
    @Order(2)
    void b_copyProduct() {
        Product copy = productFactory.copy(product1);
        assertNotNull(copy);
        assertEquals(product1.getTitle(), copy.getTitle());
        assertEquals(product1.getDescription(), copy.getDescription());
        assertEquals(product1.getPrice(), copy.getPrice());
        System.out.println("Copied product: " + copy);
    }
}
