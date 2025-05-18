package factory;

/*
ProductFactory.java
Product Factory class
Author: Thimna Gogwana 222213973
Date: 14 May 2025
*/

import domain.Product;

public class ProductFactory {
    public static Product createBasicProduct(String productID, String title, double price) {
        return new Product.Builder()
                .setProductID(productID)
                .setTitle(title)
                .setPrice(price)
                .build();
    }


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


    public static Product createCopy(Product originalProduct) {
        return new Product.Builder()
                .copy(originalProduct)
                .build();
    }


    public static Product createProductWithDiscount(Product originalProduct, double discountedPrice) {
        return new Product.Builder()
                .copy(originalProduct)
                .setPrice(discountedPrice)
                .build();
    }
    }
