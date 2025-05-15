package factory;
/*
 ProductFactory.java
 ProductFactory POJO class
 Author : Thimna Gogwana 222213973
 Date: 15 May 2025
*/
 import domain.Product;

public class ProductFactory {

    // Create a basic product with required fields
    public static Product createBasicProduct(String productID, String title, double price) {
        return new Product.Builder()
                .setProductID(productID)
                .setTitle(title)
                .setPrice(price)
                .build();
    }

    // Create a product with all fields
    public static Product createFullProduct(String productID, String title, String description,
                                            double price, String categoryID) {
        return new Product.Builder()
                .setProductID(productID)
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .setCategoryID(categoryID)
                .build();
    }

    // Create a copy of an existing product
    public static Product createCopy(Product originalProduct) {
        return new Product.Builder()
                .copy(originalProduct)
                .build();
    }

    // Create a product with promotional pricing
    public static Product createProductWithDiscount(Product originalProduct, double discountedPrice) {
        return new Product.Builder()
                .copy(originalProduct)
                .setPrice(discountedPrice)
                .build();
    }
}
