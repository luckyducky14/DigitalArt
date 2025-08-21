package za.ac.cput.service;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProductServiceTest {

    @Autowired
    private IProductService productService;

    private static Product product1;
    private static Product product2;

    @BeforeAll
    static void setUp(@Autowired ProductFactory productFactory) {
        product1 = productFactory.create(1L, 1001L, "Portrait Art", "Digital portrait of a person", 150.0);
        product2 = productFactory.create(2L, 1002L, "Abstract Art", "Colorful abstract design", 200.0);
    }

    @Test
    void a_create() {
        Product created1 = productService.create(product1);
        Product created2 = productService.create(product2);

        assertNotNull(created1);
        assertNotNull(created2);
        System.out.println("Created products: " + created1 + ", " + created2);
    }

    @Test
    void b_read() {
        Product read = productService.read(product1.getProductID());
        assertNotNull(read);
        assertEquals(150.0, read.getPrice());
        System.out.println("Read product: " + read);
    }

    @Test
    void c_update() {
        Product updated = new Product.Builder()
                .copy(product2)
                .setPrice(250.0)
                .build();
        Product result = productService.update(updated);
        assertNotNull(result);
        assertEquals(250.0, result.getPrice());
        System.out.println("Updated product: " + result);
    }

    @Test
    void d_getAll() {
        List<Product> all = productService.getAll();
        assertFalse(all.isEmpty());
        System.out.println("All products: " + all);
    }

    @Test
    void e_getByCategory() {
        List<Product> byCategory = productService.getByCategory(1001L);
        assertFalse(byCategory.isEmpty());
        System.out.println("Products by category 1001: " + byCategory);
    }

    @Test
    void f_searchByTitle() {
        List<Product> found = productService.searchByTitle("Portrait");
        assertFalse(found.isEmpty());
        System.out.println("Products found with 'Portrait': " + found);
    }

    @Test
    void g_filterByPrice() {
        List<Product> filtered = productService.filterByPrice(100.0, 200.0);
        assertFalse(filtered.isEmpty());
        System.out.println("Products between 100 and 200: " + filtered);
    }

    @Test
    void h_filterByMaxPrice() {
        List<Product> filtered = productService.filterByMaxPrice(200.0);
        assertFalse(filtered.isEmpty());
        System.out.println("Products with price <= 200: " + filtered);
    }
}
