package factory;

/*
ProductFactoryTest.java
Product Factory Test class
Author: Thimna Gogwana 222213973
Date: 18 May 2025
*/

import domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    private final String validProductID = "prod-100";
    private final String validTitle = "Smartphone";
    private final String validDescription = "Latest model with advanced features";
    private final double validPrice = 599.99;
    private final String validCategoryID = "cat-10";
    private final double validDiscountedPrice = 499.99;

    @Test
    void testCreateBasicProduct() {
        Product product = ProductFactory.createBasicProduct(validProductID, validTitle, validPrice);

        assertNotNull(product);
        assertEquals(validProductID, product.getProductID());
        assertEquals(validTitle, product.getTitle());
        assertEquals(validPrice, product.getPrice(), 0.001);
        assertNull(product.getDescription());
        assertNull(product.getCategoryID());
    }

    @Test
    void testCreateFullProduct() {
        Product product = ProductFactory.createFullProduct(
                validProductID,
                validTitle,
                validDescription,
                validPrice,
                validCategoryID);

        assertNotNull(product);
        assertEquals(validProductID, product.getProductID());
        assertEquals(validTitle, product.getTitle());
        assertEquals(validDescription, product.getDescription());
        assertEquals(validPrice, product.getPrice(), 0.001);
        assertEquals(validCategoryID, product.getCategoryID());
    }

    @Test
    void testCreateCopy() {
        Product original = ProductFactory.createFullProduct(
                validProductID,
                validTitle,
                validDescription,
                validPrice,
                validCategoryID);
        Product copy = ProductFactory.createCopy(original);

        assertNotNull(copy);
        assertEquals(original.getProductID(), copy.getProductID());
        assertEquals(original.getTitle(), copy.getTitle());
        assertEquals(original.getDescription(), copy.getDescription());
        assertEquals(original.getPrice(), copy.getPrice(), 0.001);
        assertEquals(original.getCategoryID(), copy.getCategoryID());
        assertNotSame(original, copy);
    }

    @Test
    void testCreateProductWithDiscount() {
        Product original = ProductFactory.createFullProduct(
                validProductID,
                validTitle,
                validDescription,
                validPrice,
                validCategoryID);
        Product discounted = ProductFactory.createProductWithDiscount(original, validDiscountedPrice);

        assertNotNull(discounted);
        assertEquals(validDiscountedPrice, discounted.getPrice(), 0.001);
        assertEquals(original.getProductID(), discounted.getProductID());
        assertEquals(original.getTitle(), discounted.getTitle());
        assertEquals(original.getDescription(), discounted.getDescription());
        assertEquals(original.getCategoryID(), discounted.getCategoryID());
    }

    @Test
    void testCreateWithInvalidProductID() {
        Executable action = () -> ProductFactory.createBasicProduct("", validTitle, validPrice);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid product ID: ", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidTitle() {
        Executable action = () -> ProductFactory.createBasicProduct(validProductID, "", validPrice);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid title: ", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidPrice() {
        Executable action = () -> ProductFactory.createBasicProduct(validProductID, validTitle, -1.0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid price: -1.0", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidDescription() {
        Executable action = () -> ProductFactory.createFullProduct(
                validProductID,
                validTitle,
                "",
                validPrice,
                validCategoryID);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid description", exception.getMessage());
    }

    @Test
    void testCreateWithInvalidCategoryID() {
        Executable action = () -> ProductFactory.createFullProduct(
                validProductID,
                validTitle,
                validDescription,
                validPrice,
                "");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid category ID: ", exception.getMessage());
    }

    @Test
    void testCreateCopyWithNull() {
        Executable action = () -> ProductFactory.createCopy(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Original product cannot be null", exception.getMessage());
    }

    @Test
    void testCreateWithDiscountInvalidPrice() {
        Product original = ProductFactory.createBasicProduct(validProductID, validTitle, validPrice);
        Executable action = () -> ProductFactory.createProductWithDiscount(original, -1.0);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, action);
        assertEquals("Invalid discounted price: -1.0", exception.getMessage());
    }
}