package factory;

/*
ProductFactory.java
Product Factory class
Author: Thimna Gogwana 222213973
Date: 18 May 2025
*/

import domain.Product;
import util.Helper;

public class ProductFactory {
    public static Product createBasicProduct(String productID, String title, double price) {
        validateBasicProductParameters(productID, title, price);

        return new Product.Builder()
                .setProductID(productID)
                .setTitle(title)
                .setPrice(price)
                .build();
    }

    public static Product createFullProduct(String productID, String title, String description,
                                            double price, String categoryID) {
        validateBasicProductParameters(productID, title, price);
        if (!Helper.isValidDescription(description)) {
            throw new IllegalArgumentException("Invalid description");
        }
        if (!Helper.isValidCategoryID(categoryID)) {
            throw new IllegalArgumentException("Invalid category ID: " + categoryID);
        }

        return new Product.Builder()
                .setProductID(productID)
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .setCategoryID(categoryID)
                .build();
    }

    public static Product createCopy(Product originalProduct) {
        if (originalProduct == null) {
            throw new IllegalArgumentException("Original product cannot be null");
        }
        validateProduct(originalProduct);

        return new Product.Builder()
                .copy(originalProduct)
                .build();
    }

    public static Product createProductWithDiscount(Product originalProduct, double discountedPrice) {
        if (originalProduct == null) {
            throw new IllegalArgumentException("Original product cannot be null");
        }
        if (!Helper.isValidPrice(discountedPrice)) {
            throw new IllegalArgumentException("Invalid discounted price: " + discountedPrice);
        }
        validateProduct(originalProduct);

        return new Product.Builder()
                .copy(originalProduct)
                .setPrice(discountedPrice)
                .build();
    }

    private static void validateBasicProductParameters(String productID, String title, double price) {
        if (!Helper.isValidProductID(productID)) {
            throw new IllegalArgumentException("Invalid product ID: " + productID);
        }
        if (!Helper.isValidTitle(title)) {
            throw new IllegalArgumentException("Invalid title: " + title);
        }
        if (!Helper.isValidPrice(price)) {
            throw new IllegalArgumentException("Invalid price: " + price);
        }
    }

    private static void validateProduct(Product product) {
        if (!Helper.isValidProduct(product)) {
            throw new IllegalArgumentException("Invalid product: " + product);
        }
    }
    }
