package za.ac.cput.factory;
/*
OrderItemFactoryTest.java
OrderItem Factory Test class
Author: Thimma Gogwana 222213973
Date: 25 May 2025
*/

import za.ac.cput.controller.ProductController;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.repository.CategoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private ProductFactory productFactory;

    @Autowired
    private CategoryRepository categoryRepository;

    private static Product product1;
    private static Category testCategory;

    @BeforeAll
    static void setUp(@Autowired ProductFactory productFactory,
                      @Autowired CategoryRepository categoryRepository) {
        // Create and persist a test category
        testCategory = categoryRepository.save(
                new Category.Builder()
                        .setName("Art")
                        .setDescription("Art-related items")
                        .build()
        );

        // Create product linked to the category
        product1 = productFactory.create(
                1L,
                testCategory,
                "Portrait Art",
                "Digital portrait of a person",
                150.0
        );
    }

    @Test
    void a_create() {
        Product created = productController.create(product1);
        assertNotNull(created);
        assertEquals("Portrait Art", created.getTitle());
        assertEquals(testCategory.getCategoryId(), created.getCategory().getCategoryId());
        System.out.println("Controller created product: " + created);
    }

    @Test
    void b_read() {
        Product read = productController.read(product1.getProductID());
        assertNotNull(read);
        assertEquals(product1.getProductID(), read.getProductID());
        assertEquals(testCategory.getCategoryId(), read.getCategory().getCategoryId());
        System.out.println("Controller read product: " + read);
    }

    @Test
    void c_update() {
        Product updated = new Product.Builder()
                .copy(product1)
                .setPrice(175.0)
                .build();
        Product result = productController.update(updated);
        assertNotNull(result);
        assertEquals(175.0, result.getPrice());
        System.out.println("Controller updated product: " + result);
    }

    @Test
    void d_getAll() {
        List<Product> all = productController.getAll();
        assertFalse(all.isEmpty());
        System.out.println("Controller all products: " + all);
    }

    @Test
    void e_getByCategory() {
        List<Product> byCategory = productController.getByCategory(testCategory);
        assertFalse(byCategory.isEmpty());
        assertEquals(testCategory.getCategoryId(), byCategory.get(0).getCategory().getCategoryId());
        System.out.println("Controller products by category " + testCategory.getCategoryId() + ": " + byCategory);
    }

    @Test
    void f_searchByTitle() {
        List<Product> found = productController.searchByTitle("Portrait");
        assertFalse(found.isEmpty());
        assertTrue(found.stream().anyMatch(p -> p.getTitle().contains("Portrait")));
        System.out.println("Controller products found with 'Portrait': " + found);
    }
}
