package za.ac.cput.service;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CategoryFactory;


import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static za.ac.cput.service.PaymentService.service;


    @SpringBootTest
    @TestInstance(TestInstance.Lifecycle.PER_CLASS) // Allows non-static @BeforeAll
    @TestMethodOrder(MethodOrderer.MethodName.class)
    class ProductServiceTest {

        @Autowired
        private IProductService productService;

        private Product product1;
        private Product product2;

        private Category category1;
        private Category category2;

        @BeforeAll
        void setUp() {
            // Create categories (they will be auto-persisted because of cascade)
            category1 = new Category.Builder()
                    .setName("Portraits")
                    .setDescription("Portrait artworks")
                    .build();

            category2 = new Category.Builder()
                    .setName("Abstract")
                    .setDescription("Abstract artworks")
                    .build();

            // Create products
            product1 = productService.create(
                    new Product.Builder()
                            .setCategory(category1)
                            .setTitle("Portrait Art")
                            .setDescription("Digital portrait of a person")
                            .setPrice(150.0)
                            .build()
            );

            product2 = productService.create(
                    new Product.Builder()
                            .setCategory(category2)
                            .setTitle("Abstract Art")
                            .setDescription("Colorful abstract design")
                            .setPrice(200.0)
                            .build()
            );
        }

        @Test
        void a_create() {
            assertNotNull(product1.getProductID());
            assertNotNull(product2.getProductID());
            System.out.println("Created products: " + product1 + ", " + product2);
        }

        @Test
        void b_read() {
            Product read = productService.read(product1.getProductID());
            assertNotNull(read);
            assertEquals(150.0, read.getPrice());
            assertEquals(category1.getCategoryId(), read.getCategory().getCategoryId());
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
            assertEquals(category2.getCategoryId(), result.getCategory().getCategoryId());
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
            List<Product> byCategory = productService.getByCategory(category1);
            assertFalse(byCategory.isEmpty());
            assertEquals(category1.getCategoryId(), byCategory.get(0).getCategory().getCategoryId());
            System.out.println("Products by category " + category1.getCategoryId() + ": " + byCategory);
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
        @Test
        void i_delete() {
            productService.delete(product1.getProductID());

            Product deleted = productService.read(product1.getProductID());
            assertNull(deleted, "Deleted product should not be found");

            System.out.println("Deleted product with ID: " + product1.getProductID());
        }
    }
