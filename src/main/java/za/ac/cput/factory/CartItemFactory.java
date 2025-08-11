package za.ac.cput.factory;
/*
CartItemFactory.java
CartItemFactory POJO class
Author: Thandolwethu P Mseleku
Date: 18 May 2025
*/
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class CartItemFactory {
    public static CartItem createCartItem(Cart cart, Product product, int quantity) {
        if ( cart == null || product == null || !Helper.isValidQuantity(quantity)) {
            return null;
        }

        return new CartItem.Builder()
                .setCart(cart)
                .setProduct(product)
                .setQuantity(quantity)
                .build();
    }
}
