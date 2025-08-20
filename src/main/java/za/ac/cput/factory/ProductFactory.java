package za.ac.cput.factory;

/*
ProductFactory.java
Product Factory class
Author: Thimna Gogwana 222213973
Date: 25 May 2025
*/

import za.ac.cput.domain.Product;
import za.ac.cput.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory {
    public Product create(Long productID, Long categoryID, String title, String description, double price) {
        return new Product.Builder()
                .setProductID(productID)
                .setCategoryID(categoryID)
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .build();
    }

    public Product copy(Product product) {
        return new Product.Builder()
                .copy(product)
                .build();
    }

}